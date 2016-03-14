package boilerplate;

import boilerplate.di.AppComponent;
import boilerplate.di.AppModule;
import boilerplate.di.DaggerAppComponent;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 19:56
 */
public final class App extends BoilerplateApp {

  @Override protected AppComponent createComponent() {
    return DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  @Override public void onCreate() {
    super.onCreate();
  }
}
