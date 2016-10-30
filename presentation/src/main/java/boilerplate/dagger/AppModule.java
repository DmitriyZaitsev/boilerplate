package boilerplate.dagger;

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
final class AppModule {

  @Provides
  @Singleton
  @Named("io")
  static Scheduler provideIoScheduler() {
    return Schedulers.io();
  }

  @Provides
  @Singleton
  @Named("mainThread")
  static Scheduler provideMainThreadScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
