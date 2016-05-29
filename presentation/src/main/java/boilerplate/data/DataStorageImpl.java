package boilerplate.data;

import android.support.annotation.NonNull;
import boilerplate.data.api.GitHubApi;
import boilerplate.data.api.Order;
import boilerplate.data.api.Sort;
import boilerplate.data.api.UserQuery;
import boilerplate.data.api.entity.RepositoriesResponse;
import boilerplate.data.cache.LocalCache;
import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.repository.DataStorage;
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
  private final GitHubApi        mApi;
  private final LocalCache       mCache;
  private final CloudDataMapper  mCloudDataMapper;
  private final LocalDataMapper  mLocalDataMapper;
  private final RepositoryMapper mRepositoryMapper;

  @Inject DataStorageImpl(GitHubApi api, LocalCache cache, CloudDataMapper cloudDataMapper,
      LocalDataMapper localDataMapper, RepositoryMapper repositoryMapper) {
    mApi = api;
    mCache = cache;
    mCloudDataMapper = cloudDataMapper;
    mLocalDataMapper = localDataMapper;
    mRepositoryMapper = repositoryMapper;
  }

  @Override public Observable<Collection<RepositoryDto>> getUsersRepositories(String user) {
    return Observable.concat(getCachedData(user), getServerData(user));
  }

  @NonNull private Observable<Collection<RepositoryDto>> getCachedData(final String user) {
    return mCache.findRepositoriesByOwnerName(user)
        .map(mLocalDataMapper::map);
  }

  @NonNull private Observable<Collection<RepositoryDto>> getServerData(final String user) {
    return mApi.getRepositories(new UserQuery(user), Sort.UPDATED, Order.DESC)
        .map(Result::response)
        .map(Response::body)
        .map(RepositoriesResponse::getItems)
        .doOnNext(repos -> {
          mCache.removeRepositoriesByOwnerName(user);
          mCache.saveRepositories(user, mRepositoryMapper.map(repos));
        })
        .flatMap(Observable::from)
        .toList()
        .map(mCloudDataMapper::map);
  }
}
