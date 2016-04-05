package boilerplate.presentation.presenter;

import boilerplate.common.di.PerActivity;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.view.MainRouter;
import boilerplate.presentation.view.MainScreenView;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.ReplaySubject;
import viper.Presenter;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
@PerActivity
public final class MainScreenPresenter extends Presenter<MainScreenView, MainRouter> {
  private final Provider<GetRepositoriesUseCase>      mGetRepositoriesUseCaseProvider;
  private final ReplaySubject<Collection<Repository>> mCachedResponse;
  private       GetRepositoriesUseCase                mCurrentUseCase;
  private       Subscription                          mSubscription;

  @Inject public MainScreenPresenter(Provider<GetRepositoriesUseCase> getRepositoriesUseCaseProvider) {
    mGetRepositoriesUseCaseProvider = getRepositoriesUseCaseProvider;
    mCachedResponse = ReplaySubject.create(1);
  }

  private void cancelCurrentUseCase() {
    if (mCurrentUseCase != null) {
      mCurrentUseCase.unsubscribe();
    }
  }

  @Override public void dropView() {
    super.dropView();
    cancelCurrentUseCase();
    mSubscription.unsubscribe();
  }

  @Override public void takeView(final MainScreenView view) {
    super.takeView(view);
    mSubscription = mCachedResponse.subscribe(view::setRepositories);
  }

  public void getRepositories(String userName) {
    cancelCurrentUseCase();
    mCurrentUseCase = mGetRepositoriesUseCaseProvider.get();
    mCurrentUseCase.execute(new GetRepositoriesSubscriber(mCachedResponse), userName);
  }

  public void onItemClicked(final Repository repository) {
    getRouter().goToDetailsScreen(repository);
  }

  static class GetRepositoriesSubscriber extends Subscriber<Collection<Repository>> {
    private final ReplaySubject<Collection<Repository>> mCache;

    public GetRepositoriesSubscriber(final ReplaySubject<Collection<Repository>> cache) {
      mCache = cache;
    }

    @Override public void onCompleted() {
    }

    @Override public void onError(final Throwable t) {
      mCache.onNext(new ArrayList<>());
    }

    @Override public void onNext(final Collection<Repository> repositories) {
      mCache.onNext(repositories);
    }
  }
}
