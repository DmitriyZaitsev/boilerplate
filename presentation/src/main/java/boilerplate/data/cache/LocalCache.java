package boilerplate.data.cache;

import boilerplate.data.cache.db.GithubRepository;
import java.util.Collection;
import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 02:50
 */
public interface LocalCache {

  Observable<Collection<GithubRepository>> findRepositoriesByOwnerName(String name);

  void removeRepositoriesByOwnerName(String name);

  void saveRepositories(final String user, Collection<GithubRepository> map);
}
