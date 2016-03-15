package boilerplate.domain.interactor;

import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.executor.ExecutionThread;
import boilerplate.domain.executor.PostExecutionThread;
import boilerplate.domain.repository.Repository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:40
 */
public final class GetRepositoriesUseCase extends UseCase<String, List<RepositoryDto>> {
  private final Repository mRepository;

  @Inject public GetRepositoriesUseCase(Repository repository, ExecutionThread executionThread,
      PostExecutionThread postExecutionThread) {
    super(executionThread, postExecutionThread);
    mRepository = repository;
  }

  @Override protected Observable<List<RepositoryDto>> createObservable(final String userName) {
    return mRepository.getUsersRepositories(userName);
  }
}
