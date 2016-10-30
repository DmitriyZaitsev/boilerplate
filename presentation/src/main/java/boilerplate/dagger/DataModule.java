package boilerplate.dagger;

import android.app.Application;
import boilerplate.BuildConfig;
import boilerplate.data.DataStorage;
import boilerplate.data.DataStorageImpl;
import boilerplate.data.api.GitHubApi;
import boilerplate.data.cache.LocalCache;
import boilerplate.data.cache.RealmLocalCache;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
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

  public DataModule(Application app) {
    Realm.init(app);
    Realm.setDefaultConfiguration(new RealmConfiguration.Builder().build());
  }

  @Provides
  @Singleton
  static HttpUrl provideBaseUrl() {
    return HttpUrl.parse(BuildConfig.BASE_URL_GITHUB);
  }

  @Provides
  @Singleton
  static GitHubApi provideGitHubApi(Retrofit retrofit) {
    return retrofit.create(GitHubApi.class);
  }

  @Provides
  @Singleton
  static OkHttpClient provideOkHttpClient() {
    final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    return new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addNetworkInterceptor(new StethoInterceptor())
        .build();
  }

  @Provides
  @Singleton
  static DataStorage provideDataStorage(DataStorageImpl repository) {
    return repository;
  }

  @Provides
  static Realm provideRealm() {
    return Realm.getDefaultInstance();
  }

  @Provides
  @Singleton
  static Retrofit provideRetrofit(OkHttpClient client, HttpUrl baseUrl) {
    return new Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(client)
        .build();
  }

  @Provides
  @Singleton
  static LocalCache provideLocalCache(RealmLocalCache cache) {
    return cache;
  }
}
