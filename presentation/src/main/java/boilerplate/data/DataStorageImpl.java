package boilerplate.data;

import android.support.annotation.NonNull;
import boilerplate.data.api.GitHubApi;
import boilerplate.data.api.Order;
import boilerplate.data.api.Sort;
import boilerplate.data.api.UserQuery;
import boilerplate.data.api.entity.RepositoriesResponse;
import boilerplate.data.cache.LocalCache;
import boilerplate.domain.RepositoryDto;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Response;
import retrofit2.adapter.rxjava.Result;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 23:02
 */
@Singleton
public final class DataStorageImpl implements DataStorage {
  private final GitHubApi        api;
  private final LocalCache       cache;
  private final CloudDataMapper  cloudDataMapper;
  private final LocalDataMapper  localDataMapper;
  private final RepositoryMapper repositoryMapper;

  @Inject
  DataStorageImpl(GitHubApi api, LocalCache cache, CloudDataMapper cloudDataMapper, LocalDataMapper localDataMapper,
      RepositoryMapper repositoryMapper) {
    this.api = api;
    this.cache = cache;
    this.cloudDataMapper = cloudDataMapper;
    this.localDataMapper = localDataMapper;
    this.repositoryMapper = repositoryMapper;
  }

  @Override
  public Observable<Collection<RepositoryDto>> getUsersRepositories(String user) {
    return Observable.concat(getCachedData(user), getServerData(user));
  }

  @NonNull
  private Observable<Collection<RepositoryDto>> getCachedData(final String user) {
    return cache.findRepositoriesByOwnerName(user)
        .map(localDataMapper::map);
  }

  @NonNull
  private Observable<Collection<RepositoryDto>> getServerData(final String user) {
    return api.getRepositories(new UserQuery(user), Sort.UPDATED, Order.DESC)
        .map(Result::response)
        .map(Response::body)
        .map(RepositoriesResponse::getItems)
        .doOnNext(repos -> {
          cache.removeRepositoriesByOwnerName(user);
          cache.saveRepositories(user, repositoryMapper.map(repos));
        })
        .flatMap(Observable::from)
        .toList()
        .map(cloudDataMapper::map);
  }
}
