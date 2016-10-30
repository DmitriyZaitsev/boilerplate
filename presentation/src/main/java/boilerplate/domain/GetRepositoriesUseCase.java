package boilerplate.domain;

import boilerplate.data.DataStorage;
import boilerplate.presentation.PresentationDataMapper;
import boilerplate.presentation.Repository;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Named;
import rx.Observable;
import rx.Scheduler;
import viper.Interactor;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:40
 */
public final class GetRepositoriesUseCase extends Interactor<String, Collection<Repository>> {
  private final DataStorage            repository;
  private final PresentationDataMapper mapper;

  @Inject
  GetRepositoriesUseCase(DataStorage repository, @Named("io") Scheduler jobScheduler,
      @Named("mainThread") Scheduler postExecutionScheduler, PresentationDataMapper mapper) {
    super(jobScheduler, postExecutionScheduler);
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  protected Observable<Collection<Repository>> createObservable(final String userName) {
    return repository.getUsersRepositories(userName)
        .map(mapper::map);
  }
}
