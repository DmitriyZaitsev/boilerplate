package boilerplate.presentation.view;

import boilerplate.presentation.model.Repository;
import viper.Router;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-03, 20:19
 */
public interface MainRouter extends Router {
  void goToDetailsScreen(Repository repository);

  void goToMainScreen();
}
