package boilerplate.domain.interactor;

import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.repository.Repository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Scheduler;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:40
 */
public final class GetRepositoriesUseCase extends UseCase<String, List<RepositoryDto>> {
  private final Repository mRepository;

  @Inject
  public GetRepositoriesUseCase(Repository repository, Scheduler jobScheduler, Scheduler postExecutionScheduler) {
    super(jobScheduler, postExecutionScheduler);
    mRepository = repository;
  }

  @Override protected Observable<List<RepositoryDto>> createObservable(final String userName) {
    return mRepository.getUsersRepositories(userName);
  }
}
