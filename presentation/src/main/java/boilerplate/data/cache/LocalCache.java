package boilerplate.data.cache;

import boilerplate.data.cache.db.GithubOwner;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 02:50
 */
public interface LocalCache {
  GithubOwner findOwnerById(long id);
}
