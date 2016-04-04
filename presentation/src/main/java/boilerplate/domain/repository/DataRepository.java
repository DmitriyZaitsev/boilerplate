package boilerplate.domain.repository;

import boilerplate.domain.dto.RepositoryDto;
import java.util.Collection;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 23:02
 */
public interface DataRepository {
  Observable<Collection<RepositoryDto>> getUsersRepositories(String user);
}
