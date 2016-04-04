package boilerplate.common.di;

import android.content.Context;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 19:57
 */
@Module
public final class AppModule {
  private final Context mContext;

  public AppModule(Context context) {
    mContext = context;
  }

  @NonNull @Provides @Singleton Context provideContext() {
    return mContext;
  }

  @NonNull @Provides @Singleton @Named("io") Scheduler provideIoScheduler() {
    return Schedulers.io();
  }

  @NonNull @Provides @Singleton @Named("mainThread") Scheduler provideMainThreadScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
