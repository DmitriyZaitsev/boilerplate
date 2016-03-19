package boilerplate.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import java.util.List;
import lombok.Setter;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-19, 18:02
 */
@Table(database = GithubDatabase.class, name = "owner")
@ModelContainer
@Setter
@ToString
public final class GithubOwner extends BaseModel {
  @PrimaryKey long   id;
  @Column     String login;
  @Column     String avatarUrl;

  /* package */ List<GithubRepository> repositories;

  @OneToMany(/*methods = { OneToMany.Method.SAVE, OneToMany.Method.DELETE }, */variableName = "repositories")
  public List<GithubRepository> getRepositories() {
    if (repositories == null) {
      repositories = SQLite.select()
          .from(GithubRepository.class)
          .where(GithubRepository_Table.ownerId_id.eq(id))
          .queryList();
    }
    return repositories;
  }

  //@Column String  receivedEventsUrl;
  //@Column String  organizationsUrl;
  //@Column String  gravatarId;
  //@Column String  gistsUrl;
  //@Column String  starredUrl;
  //@Column String  type;
  //@Column String  url;
  //@Column String  htmlUrl;
  //@Column String  followingUrl;
  //@Column String  eventsUrl;
  //@Column String  subscriptionsUrl;
  //@Column String  reposUrl;
  //@Column String  followersUrl;
  //@Column boolean siteAdmin;
}
