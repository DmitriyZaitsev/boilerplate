package boilerplate.presentation;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewAnimator;
import boilerplate.BoilerplateApp;
import boilerplate.R;
import boilerplate.dagger.ActivityComponent;
import boilerplate.dagger.ActivityModule;
import boilerplate.flow.Keys;
import boilerplate.flow.ScreenKeyChanger;
import flow.Flow;
import flow.KeyDispatcher;

public final class MainActivity extends AppCompatActivity implements MainRouter {

  private ScreenKeyChanger  keyChanger;
  private ActivityComponent component;

  public static ActivityComponent getComponent(Context context) {
    return ((MainActivity) ((ContextWrapper) context).getBaseContext()).component;
  }

  @Override
  public void goToDetailsScreen(Repository repository) {
    Flow.get(this)
        .set(new Keys.DetailsScreen(repository));
  }

  @Override
  public void goToMainScreen() {
    Flow.get(this)
        .set(new Keys.MainScreen());
  }

  @Override
  public void onBackPressed() {
    if (!Flow.get(this)
        .goBack()) {
      super.onBackPressed();
    }
  }

  @Override
  public ActivityComponent onRetainCustomNonConfigurationInstance() {
    return component;
  }

  @Override
  protected void attachBaseContext(final Context newBase) {
    keyChanger = new ScreenKeyChanger();
    super.attachBaseContext(Flow.configure(newBase, this)
        .defaultKey(new Keys.MainScreen())
        .dispatcher(KeyDispatcher.configure(this, keyChanger)
            .build())
        .install());
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    component = (ActivityComponent) getLastCustomNonConfigurationInstance();
    if (component == null) {
      component = ((BoilerplateApp) getApplication()).getComponent()
          .plus(new ActivityModule());
    }
    setContentView(R.layout.activity_main);
    keyChanger.setContainer((ViewAnimator) findViewById(R.id.rootView));
  }
}
