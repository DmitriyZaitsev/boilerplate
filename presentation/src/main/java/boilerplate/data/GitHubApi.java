//@formatter:off
package boilerplate.data;

import boilerplate.data.entity.RepositoriesResponse;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 16:48
 */
public interface GitHubApi {
  @GET("search/repositories")
  Observable<Result<RepositoriesResponse>> getRepositories(
      @Query("q")     UserQuery query,
      @Query("sort")  Sort      sort,
      @Query("order") Order     order
  );
}
