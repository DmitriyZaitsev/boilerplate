package boilerplate.presentation.presenter;

import boilerplate.common.di.PerActivity;
import boilerplate.presentation.view.DetailsView;
import boilerplate.presentation.view.MainRouter;
import javax.inject.Inject;
import viper.Presenter;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 03:55
 */
@PerActivity
public final class DetailsScreenPresenter extends Presenter<DetailsView, MainRouter> {
  @Inject DetailsScreenPresenter() {
  }
}
