package boilerplate.presentation;

import boilerplate.dagger.PerActivity;
import boilerplate.domain.GetRepositoriesUseCase;
import javax.inject.Inject;
import viper.ViperPresenter;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
@PerActivity
public final class MainScreenPresenter extends ViperPresenter<MainScreenView, MainRouter> {
  private final GetRepositoriesUseCase getRepositoriesUseCase;
  private       String                 userName;

  @Inject
  MainScreenPresenter(GetRepositoriesUseCase getRepositoriesUseCase) {
    this.getRepositoriesUseCase = getRepositoriesUseCase;
  }

  @Override
  public void onDropView(MainScreenView view) {
    getRepositoriesUseCase.unsubscribe();
  }

  @Override
  public void onTakeView(final MainScreenView view) {
    if (userName != null) {
      loadRepositories(userName);
    }
  }

  void loadRepositories(String userName) {
    this.userName = userName;
    getRepositoriesUseCase.execute(repositories -> {
      if (hasView()) {
        getView().setRepositories(repositories);
      }
    }, Throwable::printStackTrace, userName);
  }

  void onItemClicked(final Repository repository) {
    getRouter().goToDetailsScreen(repository);
  }
}
