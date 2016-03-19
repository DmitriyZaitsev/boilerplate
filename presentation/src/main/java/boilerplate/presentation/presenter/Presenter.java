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

  void dropView() {
    mView = null;
  }

  final V getView() {
    return mView;
  }

  public void takeView(final V view) {
    mView = view;
  }
}
