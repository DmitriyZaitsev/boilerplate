package boilerplate.data;

import android.support.annotation.NonNull;
import boilerplate.data.api.GitHubApi;
import boilerplate.data.api.Order;
import boilerplate.data.api.Sort;
import boilerplate.data.api.UserQuery;
import boilerplate.data.cache.LocalCache;
import boilerplate.data.cache.db.GithubOwner;
import boilerplate.data.cache.db.GithubRepository;
import boilerplate.data.entity.Owner;
import boilerplate.data.entity.RepositoriesResponse;
import boilerplate.data.entity.Repository;
import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.repository.DataRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Response;
import retrofit2.adapter.rxjava.Result;
import rx.Observable;
import rx.functions.Action1;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 23:02
 */
@Singleton
public final class DataRepositoryImpl implements DataRepository {
  private final GitHubApi  mApi;
  private final LocalCache mCache;

  @Inject public DataRepositoryImpl(GitHubApi api, LocalCache cache) {
    mApi = api;
    mCache = cache;
  }

  @Override public Observable<List<RepositoryDto>> getUsersRepositories(String user) {
    return mApi.getRepositories(new UserQuery(user), Sort.UPDATED, Order.DESC)
        .map(Result::response)
        .map(Response::body)
        .map(RepositoriesResponse::getItems)
        .doOnNext(saveToCache())
        .flatMap(Observable::from)
        .map(DomainDataMapper::toRepositoryDto)
        .toList();
  }

  @NonNull private Action1<List<Repository>> saveToCache() {
    return repos -> {
      for (Repository repo : repos) {
        final Owner owner = repo.getOwner();
        GithubOwner githubOwner = mCache.findOwnerById(owner.getId());
        if (githubOwner == null) {
          githubOwner = DbDataMapper.toOwner(owner);
          githubOwner.save();
        }

        final GithubRepository repository = DbDataMapper.toRepository(repo);
        repository.owner(githubOwner);
        repository.save();
      }
    };
  }
}
