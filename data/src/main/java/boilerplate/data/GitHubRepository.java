package boilerplate.data;

import boilerplate.domain.repository.Repository;
import boilerplate.domain.dto.RepositoryDto;
import java.util.List;
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
public final class GitHubRepository implements Repository {
  private final GitHubApi mApi;

  @Inject public GitHubRepository(GitHubApi api) {
    mApi = api;
  }

  @Override public Observable<List<RepositoryDto>> getUsersRepositories(String user) {
    return mApi.getRepositories(new UserQuery(user), Sort.UPDATED, Order.ASC)
        .map(Result::response)
        .doOnNext(response -> System.out.println(response.headers()))
        .map(Response::body)
        .flatMap(body -> Observable.from(body.getItems()))
        .map(DomainDataMapper::toRepositoryDto)
        .toList();
  }
}
