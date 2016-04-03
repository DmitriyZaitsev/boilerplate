package boilerplate.presentation.view.flow;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import boilerplate.presentation.view.MainActivity;
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
public class ScreenKeyChanger extends KeyChanger {

  private final MainActivity mMainActivity;

  public ScreenKeyChanger(MainActivity mainActivity) {
    mMainActivity = mainActivity;
  }

  @Override
  public void changeKey(@Nullable final State outgoingState, final State incomingState, final Direction direction,
      final Map<Object, Context> incomingContexts, final TraversalCallback callback) {
    final View originView = mMainActivity.rootView.getCurrentView();
    if (originView != null && outgoingState != null) {
      outgoingState.save(originView);
    }

    final Object key = incomingState.getKey();
    final Layout layout = (key.getClass()).getAnnotation(Layout.class);
    final Context context = incomingContexts.get(key);
    final View destinationView = (LayoutInflater.from(context)).inflate(layout.value(), mMainActivity.rootView, false);
    incomingState.restore(destinationView);

    mMainActivity.rootView.addView(destinationView);
    mMainActivity.rootView.showNext();
    mMainActivity.rootView.removeView(originView);

    callback.onTraversalCompleted();
  }
}
