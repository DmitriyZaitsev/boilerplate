package boilerplate.presentation.view.flow;

import boilerplate.R;
import boilerplate.presentation.model.Repository;
import flow.ClassKey;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-03, 20:13
 */
public final class Keys {

  @Layout(R.layout.view_details)
  public static final class DetailsScreen extends ClassKey {
    public final Repository repository;

    public DetailsScreen(final Repository repository) {
      this.repository = repository;
    }
  }

  @Layout(R.layout.view_repositories)
  public static final class MainScreen extends ClassKey {
  }
}
