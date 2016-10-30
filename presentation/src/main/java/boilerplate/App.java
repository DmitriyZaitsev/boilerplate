package boilerplate;

import boilerplate.dagger.AppComponent;
import boilerplate.dagger.DaggerAppComponent;
import boilerplate.dagger.DataModule;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 19:56
 */
public final class App extends BoilerplateApp {

  @Override
  protected AppComponent createComponent() {
    return DaggerAppComponent.builder()
        .dataModule(new DataModule(this))
        .build();
  }
}
