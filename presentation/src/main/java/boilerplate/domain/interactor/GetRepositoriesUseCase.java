package boilerplate.domain.interactor;

import boilerplate.domain.dto.RepositoryDto;
import boilerplate.domain.repository.DataRepository;
import viper.Interactor;
import java.util.Collection;
import javax.inject.Inject;
import rx.Observable;
import rx.Scheduler;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:40
 */
public final class GetRepositoriesUseCase extends Interactor<String, Collection<RepositoryDto>> {
  private final DataRepository mRepository;

  @Inject
  public GetRepositoriesUseCase(DataRepository repository, Scheduler jobScheduler, Scheduler postExecutionScheduler) {
    super(jobScheduler, postExecutionScheduler);
    mRepository = repository;
  }

  @Override protected Observable<Collection<RepositoryDto>> createObservable(final String userName) {
    return mRepository.getUsersRepositories(userName);
  }
}
