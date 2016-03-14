package boilerplate.presentation.presenter;

import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
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
  private final Provider<GetRepositoriesUseCase> mGetRepositoriesUseCaseProvider;

  @Inject public MainScreenPresenter(Provider<GetRepositoriesUseCase> getRepositoriesUseCaseProvider) {
    mGetRepositoriesUseCaseProvider = getRepositoriesUseCaseProvider;
  }

  public void getRepositories(String userName) {
    final GetRepositoriesUseCase useCase = mGetRepositoriesUseCaseProvider.get();
    useCase.execute(new GetRepositoriesSubscriber(getView()), userName);
  }

  static class GetRepositoriesSubscriber extends Subscriber<RepositoryDto> {
    private MainScreenView mView;

    public GetRepositoriesSubscriber(final MainScreenView view) {
      mView = view;
    }

    @Override public void onCompleted() {
    }

    @Override public void onError(final Throwable t) {
      mView.setText(t.getMessage());
    }

    @Override public void onNext(final RepositoryDto r) {
      final Repository repository = PresentationDataMapper.toRepository(r);
      mView.setText(repository.toString());
    }
  }
}
