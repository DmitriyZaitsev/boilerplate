package boilerplate.domain.interactor;

import boilerplate.domain.repository.Repository;
import boilerplate.domain.executor.ExecutionThread;
import boilerplate.domain.executor.PostExecutionThread;
import javax.inject.Inject;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:40
 */
public final class GetRepositoriesUseCase extends UseCase {
  private final String     mUserId;
  private final Repository mRepository;

  @Inject public GetRepositoriesUseCase(String userId, Repository repository, ExecutionThread executionThread,
      PostExecutionThread postExecutionThread) {
    super(executionThread, postExecutionThread);
    mUserId = userId;
    mRepository = repository;
  }

  @Override protected Observable createObservable() {
    return mRepository.getUsersRepositories(mUserId);
  }
}
