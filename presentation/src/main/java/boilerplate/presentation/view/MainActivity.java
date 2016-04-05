package boilerplate.presentation.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewAnimator;
import boilerplate.BoilerplateApp;
import boilerplate.R;
import boilerplate.common.di.ActivityComponent;
import boilerplate.common.di.ActivityModule;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.view.flow.Keys;
import boilerplate.presentation.view.flow.ScreenKeyChanger;
import flow.Flow;
import flow.KeyDispatcher;

public class MainActivity extends AppCompatActivity implements MainRouter {

  private ScreenKeyChanger  mKeyChanger;
  private ActivityComponent mComponent;

  public static ActivityComponent getComponent(Context context) {
    return (((MainActivity) ((ContextWrapper) context).getBaseContext()).mComponent);
  }

  @Override protected void attachBaseContext(final Context newBase) {
    mKeyChanger = new ScreenKeyChanger();
    super.attachBaseContext(Flow.configure(newBase, this)
        .defaultKey(new Keys.MainScreen())
        .dispatcher((KeyDispatcher.configure(this, mKeyChanger)).build())
        .install());
  }

  @Override public void goToDetailsScreen(Repository repository) {
    (Flow.get(this)).set(new Keys.DetailsScreen(repository));
  }

  @Override public void goToMainScreen() {
    (Flow.get(this)).set(new Keys.MainScreen());
  }

  @Override public void onBackPressed() {
    if (!(Flow.get(this)).goBack()) {
      super.onBackPressed();
    }
  }

  @Override public ActivityComponent onRetainCustomNonConfigurationInstance() {
    return mComponent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mComponent = ((ActivityComponent) getLastCustomNonConfigurationInstance());
    if (mComponent == null) {
      mComponent = (((BoilerplateApp) getApplication()).getComponent()).plus(new ActivityModule());
    }
    setContentView(R.layout.activity_main);
    mKeyChanger.setContainer((ViewAnimator) findViewById(R.id.rootView));
  }
}
