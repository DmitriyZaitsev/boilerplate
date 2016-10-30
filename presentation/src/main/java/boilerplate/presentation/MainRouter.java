package boilerplate.presentation;

import viper.Router;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-03, 20:19
 */
interface MainRouter extends Router {
  void goToDetailsScreen(Repository repository);

  void goToMainScreen();
}
