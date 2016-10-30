package boilerplate.presentation;

import java.util.Collection;
import viper.ViewCallbacks;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:30
 */
interface MainScreenView extends ViewCallbacks {
  void setRepositories(Collection<Repository> repositories);
}
