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
import java.util.Collection;
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
  private final GitHubApi        mApi;
  private final LocalCache       mCache;
  private final DomainDataMapper mDomainDataMapper;
  private final OwnerMapper      mOwnerMapper;
  private final RepositoryMapper mRepositoryMapper;

  @Inject
  public DataRepositoryImpl(GitHubApi api, LocalCache cache, DomainDataMapper domainDataMapper, OwnerMapper ownerMapper,
      RepositoryMapper repositoryMapper) {
    mApi = api;
    mCache = cache;
    mDomainDataMapper = domainDataMapper;
    mOwnerMapper = ownerMapper;
    mRepositoryMapper = repositoryMapper;
  }

  @Override public Observable<Collection<RepositoryDto>> getUsersRepositories(String user) {
    return mApi.getRepositories(new UserQuery(user), Sort.UPDATED, Order.DESC)
        .map(Result::response)
        .map(Response::body)
        .map(RepositoriesResponse::getItems)
        .doOnNext(saveToCache())
        .flatMap(Observable::from)
        .toList()
        .map(mDomainDataMapper::map);
  }

  @NonNull private Action1<List<Repository>> saveToCache() {
    return repos -> {
      for (Repository repo : repos) {
        final Owner owner = repo.getOwner();
        GithubOwner githubOwner = mCache.findOwnerById(owner.getId());
        if (githubOwner == null) {
          githubOwner = mOwnerMapper.map(owner);
          githubOwner.save();
        }

        final GithubRepository repository = mRepositoryMapper.map(repo);
        repository.owner(githubOwner);
        repository.save();
      }
    };
  }
}
