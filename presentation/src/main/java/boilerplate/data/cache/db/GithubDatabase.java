package boilerplate.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-19, 17:55
 */
@Database(name = GithubDatabase.NAME, version = GithubDatabase.VERSION, foreignKeysSupported = true)
final class GithubDatabase {
  static final String NAME    = "Github";
  static final int    VERSION = 1;
}
