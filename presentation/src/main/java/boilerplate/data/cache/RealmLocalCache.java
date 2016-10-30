package boilerplate.data.cache;

import boilerplate.data.cache.db.GithubOwner;
import boilerplate.data.cache.db.GithubRepository;
import io.realm.Case;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.Collection;
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
  private final Provider<Realm> realmProvider;

  @Inject
  RealmLocalCache(Provider<Realm> realmProvider) {
    this.realmProvider = realmProvider;
  }

  private static GithubOwner findOwner(String name, Realm realm) {
    return realm.where(GithubOwner.class)
        .equalTo("login", name, Case.INSENSITIVE)
        .findFirst();
  }

  @Override
  public Observable<Collection<GithubRepository>> findRepositoriesByOwnerName(final String name) {
    return Observable.fromCallable(() -> {
      final GithubOwner owner = findOwner(name, realmProvider.get());
      return (owner == null) ? new ArrayList<>() : owner.getRepositories();
    });
  }

  @Override
  public void removeRepositoriesByOwnerName(final String name) {
    realmProvider.get()
        .executeTransaction(db -> {
          final GithubOwner owner = findOwner(name, db);
          if (owner != null) {
            owner.getRepositories()
                .deleteAllFromRealm();
          }
        });
  }

  @Override
  public void saveRepositories(final String user, final Collection<GithubRepository> repositories) {
    realmProvider.get()
        .executeTransaction(db -> {
          for (GithubRepository repository : repositories) {
            db.copyToRealmOrUpdate(repository);
            final GithubOwner owner = repository.getOwner();
            owner.getRepositories()
                .addAll(repositories);
            db.copyToRealmOrUpdate(owner);
          }
          db.copyToRealmOrUpdate(repositories);
        });
  }
}
