package boilerplate.presentation.presenter;

import boilerplate.presentation.view.View;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:34
 */
public interface Presenter<V extends View> {
  void dropView();

  void takeView(V view);
}
