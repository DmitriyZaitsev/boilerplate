package boilerplate.presentation.presenter;

import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.presentation.PresentationDataMapper;
import boilerplate.presentation.view.MainScreenView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import rx.Observable;
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

  static class GetRepositoriesSubscriber extends Subscriber<List<RepositoryDto>> {
    private MainScreenView mView;

    public GetRepositoriesSubscriber(final MainScreenView view) {
      mView = view;
    }

    @Override public void onCompleted() {
    }

    @Override public void onError(final Throwable t) {
      mView.setRepositories(new ArrayList<>());
    }

    @Override public void onNext(final List<RepositoryDto> r) {
      Observable.from(r)
          .map(PresentationDataMapper::toRepository)
          .toList()
          .subscribe(repositories -> mView.setRepositories(repositories));
    }
  }
}
