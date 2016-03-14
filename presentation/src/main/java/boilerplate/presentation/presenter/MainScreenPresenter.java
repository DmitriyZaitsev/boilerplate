package boilerplate.presentation.presenter;

import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.interactor.UseCase;
import boilerplate.presentation.PresentationDataMapper;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.view.MainScreenView;
import javax.inject.Inject;
import javax.inject.Provider;
import rx.Subscriber;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:31
 */
public final class MainScreenPresenter extends Presenter<MainScreenView> {
  private final Provider<UseCase> mUseCase;

  @Inject public MainScreenPresenter(Provider<UseCase> useCase) {
    mUseCase = useCase;
  }

  public void getRepositories() {
    final UseCase useCase = mUseCase.get();
    useCase.execute(new Subscriber<RepositoryDto>() {
      @Override public void onCompleted() {
      }

      @Override public void onError(final Throwable t) {
        getView().setText(t.getMessage());
      }

      @Override public void onNext(final RepositoryDto r) {
        final Repository repository = PresentationDataMapper.toRepository(r);
        getView().setText(repository.toString());
      }
    });
  }
}
