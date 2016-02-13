package boilerplate.di;

import android.content.Context;
import android.support.annotation.NonNull;
import boilerplate.data.ExecutionThread;
import boilerplate.data.PostExecutionThread;
import boilerplate.data.Repository;
import boilerplate.presenter.MainScreenPresenter;
import boilerplate.presenter.MainScreenPresenterImpl;
import boilerplate.usecase.GetRepositoriesUseCase;
import boilerplate.usecase.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
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
  private final String  mUserId;

  public AppModule(Context context, String userId) {
    mContext = context;
    mUserId = userId;
  }

  @Provides @Singleton Context provideContext() {
    return mContext;
  }

  @Provides @Named("getRepositories") UseCase provideGetRepositoriesUseCase(Repository repository,
      ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
    return new GetRepositoriesUseCase(mUserId, repository, executionThread, postExecutionThread);
  }

  @NonNull @Provides @Singleton ExecutionThread provideIoExecutionThread() {
    return Schedulers::io;
  }

  @NonNull @Provides @Singleton PostExecutionThread provideMainExecutionThread() {
    return AndroidSchedulers::mainThread;
  }

  @Provides MainScreenPresenter provideMainScreenPresenter(MainScreenPresenterImpl presenter) {
    return presenter;
  }
}
