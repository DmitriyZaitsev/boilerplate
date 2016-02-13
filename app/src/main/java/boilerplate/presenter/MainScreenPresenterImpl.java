package boilerplate.presenter;

import boilerplate.usecase.UseCase;
import boilerplate.view.MainScreenView;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import rx.Subscriber;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
public final class MainScreenPresenterImpl extends AbstractPresenter<MainScreenView> implements MainScreenPresenter {
  private final Provider<UseCase> mUseCase;

  @Inject public MainScreenPresenterImpl(@Named("getRepositories") Provider<UseCase> useCase) {
    mUseCase = useCase;
  }

  @Override public void getRepositories() {
    final UseCase useCase = mUseCase.get();
    useCase.execute(new Subscriber<String>() {
      @Override public void onCompleted() {
      }

      @Override public void onError(final Throwable e) {
        getView().setText(e.getMessage());
      }

      @Override public void onNext(final String o) {
        getView().setText(o);
      }
    });
  }
}
