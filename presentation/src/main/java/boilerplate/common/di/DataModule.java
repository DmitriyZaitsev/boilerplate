package boilerplate.common.di;

import android.support.annotation.NonNull;
import boilerplate.BuildConfig;
import boilerplate.data.api.GitHubApi;
import boilerplate.data.GitHubRepository;
import boilerplate.domain.repository.Repository;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import lombok.val;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 19:29
 */
@Module
public final class DataModule {
  @NonNull @Provides @Singleton HttpUrl provideBaseUrl() {
    return HttpUrl.parse(BuildConfig.BASE_URL_GITHUB);
  }

  @Provides @Singleton GitHubApi provideGitHubApi(Retrofit retrofit) {
    return retrofit.create(GitHubApi.class);
  }

  @NonNull @Provides @Singleton OkHttpClient provideOkHttpClient() {
    val loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(
        BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    return new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addNetworkInterceptor(new StethoInterceptor())
        .build();
  }

  @NonNull @Provides @Singleton Repository provideRepository(GitHubRepository repository) {
    return repository;
  }

  @NonNull @Provides @Singleton Retrofit provideRetrofit(OkHttpClient client, HttpUrl baseUrl) {
    return new Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(client)
        .build();
  }
}
