package boilerplate.presentation;

import boilerplate.dagger.PerActivity;
import javax.inject.Inject;
import viper.ViperPresenter;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 03:55
 */
@PerActivity
public final class DetailsScreenPresenter extends ViperPresenter<DetailsView, MainRouter> {
  @Inject
  DetailsScreenPresenter() {
  }
}
