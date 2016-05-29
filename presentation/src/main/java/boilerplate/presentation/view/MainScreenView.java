package boilerplate.presentation.view;

import boilerplate.presentation.model.Repository;
import java.util.Collection;
import viper.ViewCallbacks;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:30
 */
public interface MainScreenView extends ViewCallbacks {
  void setRepositories(final Collection<Repository> repositories);
}
