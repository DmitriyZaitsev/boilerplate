package boilerplate.domain.repository;

import boilerplate.domain.dto.RepositoryDto;
import java.util.List;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 23:02
 */
public interface Repository {
  Observable<List<RepositoryDto>> getUsersRepositories(String user);
}
