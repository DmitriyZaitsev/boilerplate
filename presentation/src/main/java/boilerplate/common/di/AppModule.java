package boilerplate.common.di;

import android.content.Context;
import android.support.annotation.NonNull;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.domain.repository.DataRepository;
import boilerplate.presentation.PresentationDataMapper;
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

  @NonNull
  @Provides
  @Singleton
  Context provideContext() {
    return mContext;
  }

  @Provides
  GetRepositoriesUseCase provideGetRepositoriesUseCase(DataRepository repository,
      @Named("io") Scheduler jobScheduler, @Named("mainThread") Scheduler postExecutionScheduler) {
    return new GetRepositoriesUseCase(repository, jobScheduler, postExecutionScheduler);
  }

  @NonNull
  @Provides
  @Singleton
  @Named("io")
  Scheduler provideIoScheduler() {
    return Schedulers.io();
  }

  @NonNull
  @Provides
  @Singleton
  MainScreenPresenter provideMainScreenPresenter(Provider<GetRepositoriesUseCase> useCase, PresentationDataMapper mapper) {
    return new MainScreenPresenter(useCase, mapper);
  }

  @NonNull
  @Provides
  @Singleton
  @Named("mainThread")
  Scheduler provideMainThreadScheduler() {
    return AndroidSchedulers.mainThread();
  }

  @NonNull
  @Provides
  @Singleton
  PresentationDataMapper providePresentationDataMapper() {
    return new PresentationDataMapper();
  }
}
