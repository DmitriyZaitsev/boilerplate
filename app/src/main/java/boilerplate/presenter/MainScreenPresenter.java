package boilerplate.presenter;

import boilerplate.view.MainScreenView;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
public interface MainScreenPresenter extends Presenter<MainScreenView> {
  void getRepositories();
}
