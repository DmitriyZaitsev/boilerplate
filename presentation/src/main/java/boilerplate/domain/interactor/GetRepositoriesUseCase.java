package boilerplate.domain.interactor;

import boilerplate.domain.repository.DataStorage;
import boilerplate.presentation.PresentationDataMapper;
import boilerplate.presentation.model.Repository;
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
  private final DataStorage            mRepository;
  private final PresentationDataMapper mMapper;

  @Inject GetRepositoriesUseCase(DataStorage repository, @Named("io") Scheduler jobScheduler,
      @Named("mainThread") Scheduler postExecutionScheduler, PresentationDataMapper mapper) {
    super(jobScheduler, postExecutionScheduler);
    mRepository = repository;
    mMapper = mapper;
  }

  @Override protected Observable<Collection<Repository>> createObservable(final String userName) {
    return mRepository.getUsersRepositories(userName)
        .map(mMapper::map);
  }
}
