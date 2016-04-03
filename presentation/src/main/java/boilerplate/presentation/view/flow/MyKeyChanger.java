package boilerplate.presentation.view.flow;

import android.content.Context;
import android.support.annotation.Nullable;
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
public class MyKeyChanger extends KeyChanger {

  private final MainActivity mMainActivity;

  public MyKeyChanger(MainActivity mainActivity) {
    mMainActivity = mainActivity;
  }

  @Override
  public void changeKey(@Nullable final State outgoingState, final State incomingState, final Direction direction,
      final Map<Object, Context> incomingContexts, final TraversalCallback callback) {

    callback.onTraversalCompleted();
  }
}
