package boilerplate.common.di;

import boilerplate.presentation.view.ui.RepositoriesView;
import dagger.Component;
import javax.inject.Singleton;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 19:56
 */
@Singleton
@Component(modules = { AppModule.class, DataModule.class })
public interface AppComponent {
  void inject(RepositoriesView view);
}
