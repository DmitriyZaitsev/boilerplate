package boilerplate.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewAnimator;
import boilerplate.R;
import boilerplate.presentation.view.flow.Keys;
import boilerplate.presentation.view.flow.ScreenKeyChanger;
import flow.Flow;
import flow.KeyDispatcher;

public class MainActivity extends AppCompatActivity implements MainRouter {

  public ViewAnimator rootView;

  @Override protected void attachBaseContext(final Context newBase) {
    super.attachBaseContext(Flow.configure(newBase, this)
        .defaultKey(new Keys.MainScreen())
        .dispatcher((KeyDispatcher.configure(this, new ScreenKeyChanger(this))).build())
        .install());
  }

  @Override public void goToDetailsScreen() {
    (Flow.get(this)).set(new Keys.DetailsScreen());
  }

  @Override public void goToMainScreen() {
    (Flow.get(this)).set(new Keys.MainScreen());
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    rootView = (ViewAnimator) findViewById(R.id.rootView);
  }
}
