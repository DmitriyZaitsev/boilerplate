package boilerplate.flow;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewAnimator;
import boilerplate.presentation.DetailsView;
import flow.Direction;
import flow.KeyChanger;
import flow.State;
import flow.TraversalCallback;
import java.util.Map;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-03, 20:10
 */
public final class ScreenKeyChanger implements KeyChanger {

  private ViewAnimator container;

  @Override
  public void changeKey(@Nullable final State outgoingState, final State incomingState, final Direction direction,
      final Map<Object, Context> incomingContexts, final TraversalCallback callback) {
    final View originView = container.getCurrentView();
    if (originView != null && outgoingState != null) {
      outgoingState.save(originView);
    }

    final Object key = incomingState.getKey();
    final Layout layout = key.getClass()
        .getAnnotation(Layout.class);
    final Context context = incomingContexts.get(key);
    final View destinationView = LayoutInflater.from(context)
        .inflate(layout.value(), container, false);
    incomingState.restore(destinationView);

    if (key instanceof Keys.DetailsScreen) {
      ((DetailsView) destinationView).bind(((Keys.DetailsScreen) key).repository);
    }

    container.addView(destinationView);
    container.showNext();
    container.removeView(originView);

    callback.onTraversalCompleted();
  }

  public void setContainer(final ViewAnimator container) {
    this.container = container;
  }
}
