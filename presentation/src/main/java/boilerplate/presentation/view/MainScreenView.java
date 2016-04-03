package boilerplate.presentation.view;

import boilerplate.viper.View;
import boilerplate.presentation.model.Repository;
import java.util.List;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:30
 */
public interface MainScreenView extends View {
  void setRepositories(final List<Repository> repositories);
}
