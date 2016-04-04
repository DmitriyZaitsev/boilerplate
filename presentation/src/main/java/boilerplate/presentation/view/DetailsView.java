package boilerplate.presentation.view;

import boilerplate.presentation.model.Repository;
import viper.View;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 03:48
 */
public interface DetailsView extends View {
  void bind(Repository repository);
}
