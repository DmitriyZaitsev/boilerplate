package boilerplate.di;

import android.content.Context;
import android.support.annotation.NonNull;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.domain.repository.Repository;
import boilerplate.presentation.presenter.MainScreenPresenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Provider;
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

  @Provides @Singleton Context provideContext() {
    return mContext;
  }

  @Provides GetRepositoriesUseCase provideGetRepositoriesUseCase(Repository repository,
      @Named("io") Scheduler jobScheduler, @Named("mainThread") Scheduler postExecutionScheduler) {
    return new GetRepositoriesUseCase(repository, jobScheduler, postExecutionScheduler);
  }

  @NonNull @Provides @Singleton @Named("io") Scheduler provideIoScheduler() {
    return Schedulers.io();
  }

  @Provides MainScreenPresenter provideMainScreenPresenter(Provider<GetRepositoriesUseCase> useCase) {
    return new MainScreenPresenter(useCase);
  }

  @NonNull @Provides @Singleton @Named("mainThread") Scheduler provideMainThreadScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
