package boilerplate.presentation.presenter;

import boilerplate.viper.Presenter;
import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.interactor.GetRepositoriesUseCase;
import boilerplate.presentation.PresentationDataMapper;
import boilerplate.presentation.view.MainRouter;
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
public final class MainScreenPresenter extends Presenter<MainScreenView, MainRouter> {
  private final Provider<GetRepositoriesUseCase> mGetRepositoriesUseCaseProvider;
  private final PresentationDataMapper           mDataMapper;
  private       GetRepositoriesUseCase           mCurrentUseCase;

  @Inject public MainScreenPresenter(Provider<GetRepositoriesUseCase> getRepositoriesUseCaseProvider,
      PresentationDataMapper dataMapper) {
    mGetRepositoriesUseCaseProvider = getRepositoriesUseCaseProvider;
    mDataMapper = dataMapper;
  }

  private void cancelCurrentUseCase() {
    if (mCurrentUseCase != null) {
      mCurrentUseCase.unsubscribe();
    }
  }

  @Override public void dropView() {
    super.dropView();
    cancelCurrentUseCase();
  }

  public void getRepositories(String userName) {
    cancelCurrentUseCase();
    mCurrentUseCase = mGetRepositoriesUseCaseProvider.get();
    mCurrentUseCase.execute(new GetRepositoriesSubscriber(getView(), mDataMapper), userName);
  }

  static class GetRepositoriesSubscriber extends Subscriber<List<RepositoryDto>> {
    private final MainScreenView         mView;
    private final PresentationDataMapper mDataMapper;

    public GetRepositoriesSubscriber(final MainScreenView view, final PresentationDataMapper dataMapper) {
      mView = view;
      mDataMapper = dataMapper;
    }

    @Override public void onCompleted() {
    }

    @Override public void onError(final Throwable t) {
      mView.setRepositories(new ArrayList<>());
    }

    @Override public void onNext(final List<RepositoryDto> r) {
      Observable.from(r)
          .toList()
          .map(mDataMapper::map)
          .subscribe(mView::setRepositories);
    }
  }
}
