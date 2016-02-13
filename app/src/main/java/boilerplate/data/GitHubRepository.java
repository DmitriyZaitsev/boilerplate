package boilerplate.data;

import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

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

  @Override public Observable<String> getUsersRepositories(String user) {
    return Observable.create(new Observable.OnSubscribe<String>() {
      @Override public void call(final Subscriber<? super String> subscriber) {
        mApi.getUserIdRepos(user, "all")
            .enqueue(new Callback<ResponseBody>() {
              @Override public void onResponse(final Call<ResponseBody> call, final Response<ResponseBody> response) {
                try {
                  subscriber.onNext(response.body()
                      .string());
                  subscriber.onCompleted();
                } catch (IOException e) {
                  subscriber.onError(e);
                }
              }

              @Override public void onFailure(final Call<ResponseBody> call, final Throwable t) {
                subscriber.onError(t);
              }
            });
      }
    });
  }
}
