package boilerplate;

import android.app.Application;
import boilerplate.dagger.AppComponent;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 21:52
 */
public abstract class BoilerplateApp extends Application {
  private AppComponent component;

  public final AppComponent getComponent() {
    return component;
  }

  @Override
  public final void onCreate() {
    super.onCreate();
    component = createComponent();
    Stetho.initialize(Stetho.newInitializerBuilder(this)
        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this)
            .build())
        .build());
  }

  protected abstract AppComponent createComponent();
}
