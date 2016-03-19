package boilerplate;

import android.app.Application;
import boilerplate.common.di.AppComponent;
import com.facebook.stetho.Stetho;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 21:52
 */
public abstract class BoilerplateApp extends Application {
  private AppComponent mComponent;

  protected abstract AppComponent createComponent();

  public AppComponent getComponent() {
    return mComponent;
  }

  @Override public void onCreate() {
    super.onCreate();
    mComponent = createComponent();
    Stetho.initializeWithDefaults(this);
  }
}
