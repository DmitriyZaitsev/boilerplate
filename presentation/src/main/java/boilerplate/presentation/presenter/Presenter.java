package boilerplate.presentation.presenter;

import boilerplate.presentation.view.View;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:33
 */
abstract class Presenter<V extends View> {
  private V mView;

  public void dropView() {
    mView = null;
  }

  public void takeView(final V view) {
    mView = view;
  }

  protected V getView() {
    return mView;
  }
}
