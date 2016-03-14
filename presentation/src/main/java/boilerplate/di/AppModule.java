package boilerplate.di;

import android.content.Context;
import android.support.annotation.NonNull;
import boilerplate.domain.executor.ExecutionThread;
import boilerplate.domain.executor.PostExecutionThread;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.domain.repository.Repository;
import boilerplate.presentation.presenter.MainScreenPresenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Provider;
import javax.inject.Singleton;
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

  @Provides GetRepositoriesUseCase provideGetRepositoriesUseCase(Repository repository, ExecutionThread executionThread,
      PostExecutionThread postExecutionThread) {
    return new GetRepositoriesUseCase(repository, executionThread, postExecutionThread);
  }

  @NonNull @Provides @Singleton ExecutionThread provideIoExecutionThread() {
    return Schedulers::io;
  }

  @NonNull @Provides @Singleton PostExecutionThread provideMainExecutionThread() {
    return AndroidSchedulers::mainThread;
  }

  @Provides MainScreenPresenter provideMainScreenPresenter(Provider<GetRepositoriesUseCase> useCase) {
    return new MainScreenPresenter(useCase);
  }
}
