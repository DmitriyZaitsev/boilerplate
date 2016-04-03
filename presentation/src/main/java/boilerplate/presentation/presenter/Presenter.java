package boilerplate.presentation.presenter;

import boilerplate.presentation.view.Router;
import boilerplate.presentation.view.View;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:33
 */
abstract class Presenter<V extends View, R extends Router> {
  private V mView;
  private R mRouter;

  void dropView() {
    mView = null;
  }

  public void dropRouter() {
    mRouter = null;
  }

  final V getView() {
    return mView;
  }

  final R getRouter() {
    return mRouter;
  }

  public void takeView(final V view) {
    mView = view;
  }

  public void takeRouter(final R router) {
    mRouter = router;
  }
}
