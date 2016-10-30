package boilerplate.dagger;

import boilerplate.presentation.RepositoriesView;
import boilerplate.presentation.RepositoryDetailsView;
import dagger.Subcomponent;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-05, 13:39
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
  void inject(RepositoriesView view);

  void inject(RepositoryDetailsView view);
}
