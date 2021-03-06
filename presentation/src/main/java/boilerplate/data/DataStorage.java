package boilerplate.data;

import boilerplate.domain.RepositoryDto;
import java.util.Collection;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 23:02
 */
public interface DataStorage {
  Observable<Collection<RepositoryDto>> getUsersRepositories(String user);
}
