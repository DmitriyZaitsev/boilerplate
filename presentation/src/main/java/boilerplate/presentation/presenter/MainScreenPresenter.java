package boilerplate.presentation.presenter;

import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.view.MainRouter;
import boilerplate.presentation.view.MainScreenView;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;
import rx.Subscriber;
import viper.Presenter;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
public final class MainScreenPresenter extends Presenter<MainScreenView, MainRouter> {
  private final Provider<GetRepositoriesUseCase> mGetRepositoriesUseCaseProvider;
  private       GetRepositoriesUseCase           mCurrentUseCase;

  @Inject public MainScreenPresenter(Provider<GetRepositoriesUseCase> getRepositoriesUseCaseProvider) {
    mGetRepositoriesUseCaseProvider = getRepositoriesUseCaseProvider;
  }

  private void cancelCurrentUseCase() {
    if (mCurrentUseCase != null) {
      mCurrentUseCase.unsubscribe();
    }
  }

  @Override public void dropView() {
    super.dropView();
    cancelCurrentUseCase();
  }

  public void getRepositories(String userName) {
    cancelCurrentUseCase();
    mCurrentUseCase = mGetRepositoriesUseCaseProvider.get();
    mCurrentUseCase.execute(new GetRepositoriesSubscriber(getView()), userName);
  }

  public void onItemClicked(final Repository repository) {
    getRouter().goToDetailsScreen(repository);
  }

  static class GetRepositoriesSubscriber extends Subscriber<Collection<Repository>> {
    private final MainScreenView mView;

    public GetRepositoriesSubscriber(final MainScreenView view) {
      mView = view;
    }

    @Override public void onCompleted() {
    }

    @Override public void onError(final Throwable t) {
      mView.setRepositories(new ArrayList<>());
    }

    @Override public void onNext(final Collection<Repository> repositories) {
      mView.setRepositories(repositories);
    }
  }
}
