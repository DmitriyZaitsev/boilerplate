package boilerplate.presentation.presenter;

import boilerplate.common.di.PerActivity;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.view.MainRouter;
import boilerplate.presentation.view.MainScreenView;
import javax.inject.Inject;
import viper.Presenter;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
@PerActivity
public final class MainScreenPresenter extends Presenter<MainScreenView, MainRouter> {
  private final GetRepositoriesUseCase mGetRepositoriesUseCase;
  private String mUserName;

  @Inject MainScreenPresenter(GetRepositoriesUseCase getRepositoriesUseCase) {
    mGetRepositoriesUseCase = getRepositoriesUseCase;
  }

  @Override public void onDropView(MainScreenView view) {
    mGetRepositoriesUseCase.unsubscribe();
  }

  @Override public void onTakeView(final MainScreenView view) {
    if (mUserName != null) {
      getRepositories(mUserName);
    }
  }

  public void getRepositories(String userName) {
    mUserName = userName;
    mGetRepositoriesUseCase.execute(repositories -> {
      getView().setRepositories(repositories);
      System.out.println("GetRepositories.onNext");
      System.out.println("repositories = [" + repositories + "]");
    }, t -> {
      System.err.println("GetRepositoriesS.onError");
      System.err.println("t = [" + t + "]");
      t.printStackTrace();
    }, userName);
  }

  public void onItemClicked(final Repository repository) {
    getRouter().goToDetailsScreen(repository);
  }
}
