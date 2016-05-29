package boilerplate;

import boilerplate.common.di.AppComponent;
import boilerplate.common.di.AppModule;
import boilerplate.common.di.DaggerAppComponent;
import boilerplate.common.di.DataModule;

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
        .dataModule(new DataModule(this))
        .build();
  }

  @Override public void onCreate() {
    super.onCreate();
  }
}
