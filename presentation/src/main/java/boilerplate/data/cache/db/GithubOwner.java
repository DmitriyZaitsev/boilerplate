package boilerplate.data.cache.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-19, 18:02
 */
@Setter
@Getter
@ToString
public class GithubOwner extends RealmObject {
  @PrimaryKey long id;
  String login;
  String avatarUrl;
  RealmList<GithubRepository> repositories = new RealmList<>();

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
