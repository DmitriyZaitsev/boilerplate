package boilerplate.data.cache;

import boilerplate.data.cache.db.GithubOwner;
import boilerplate.data.cache.db.GithubOwner_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 02:51
 */
@Singleton
public final class DbFlowLocalCache implements LocalCache {
  @Inject DbFlowLocalCache() {
  }

  @Override public GithubOwner findOwnerById(final long id) {
    return SQLite.select()
        .from(GithubOwner.class)
        .where(GithubOwner_Table.id.is(id))
        .querySingle();
  }
}
