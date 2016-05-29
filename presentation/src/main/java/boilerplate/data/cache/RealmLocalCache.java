package boilerplate.data.cache;

import boilerplate.data.cache.db.GithubOwner;
import boilerplate.data.cache.db.GithubRepository;
import io.realm.Case;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 02:51
 */
@Singleton
public final class RealmLocalCache implements LocalCache {
  private final Provider<Realm> mRealmProvider;

  @Inject RealmLocalCache(Provider<Realm> realmProvider) {
    mRealmProvider = realmProvider;
  }

  @Override public Observable<Collection<GithubRepository>> findRepositoriesByOwnerName(final String name) {
    return Observable.fromCallable(() -> getRepositoriesInternal(name));
  }

  private List<GithubRepository> getRepositoriesInternal(final String name) {
    final Realm realm = mRealmProvider.get();
    try {
      final GithubOwner owner = realm.where(GithubOwner.class)
          .equalTo("login", name, Case.INSENSITIVE)
          .findFirst();
      return (owner == null) ? new ArrayList<>() : owner.getRepositories();
    } finally {
      //realm.close();
    }
  }

  @Override public void removeRepositoriesByOwnerName(final String name) {
    final Realm realm = mRealmProvider.get();
    try {
      realm.executeTransaction(realm1 -> {
        final GithubOwner owner = realm1.where(GithubOwner.class)
            .equalTo("login", name, Case.INSENSITIVE)
            .findFirst();
        if (owner != null) {
          owner.getRepositories()
              .deleteAllFromRealm();
        }
      });
    } finally {
      //realm.close();
    }
  }

  @Override public void saveRepositories(final String user, final Collection<GithubRepository> repositories) {
    final Realm realm = mRealmProvider.get();
    try {
      realm.executeTransaction(realm1 -> {
        for (GithubRepository repository : repositories) {
          realm1.copyToRealmOrUpdate(repository);
          final GithubOwner owner = repository.getOwner();
          owner.getRepositories()
              .addAll(repositories);
          realm1.copyToRealmOrUpdate(owner);
        }
        realm1.copyToRealmOrUpdate(repositories);
      });
    } finally {
      //realm.close();
    }
  }
}
