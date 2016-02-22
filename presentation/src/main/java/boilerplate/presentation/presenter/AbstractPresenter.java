package boilerplate.presentation.presenter;

import boilerplate.presentation.view.View;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:33
 */
abstract class AbstractPresenter<V extends View> implements Presenter<V> {
  private V mView;

  @Override public void dropView() {
    mView = null;
  }

  @Override public void takeView(final V view) {
    mView = view;
  }

  protected V getView() {
    return mView;
  }
}
