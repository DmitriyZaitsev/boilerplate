package boilerplate.data.cache.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-19, 17:59
 */
@Setter
@Getter
@ToString
public class GithubRepository extends RealmObject {
  @PrimaryKey long id;
  String      name;
  String      description;
  String      htmlUrl;
  String      updatedAt;
  long        watchers;
  long        forks;
  GithubOwner owner;

  //@Column String  fullName;
  //@Column String  url;
  //@Column String  forksUrl;
  //@Column String  keysUrl;
  //@Column String  collaboratorsUrl;
  //@Column String  teamsUrl;
  //@Column String  hooksUrl;
  //@Column String  issueEventsUrl;
  //@Column String  eventsUrl;
  //@Column String  assigneesUrl;
  //@Column String  branchesUrl;
  //@Column String  tagsUrl;
  //@Column String  blobsUrl;
  //@Column String  gitTagsUrl;
  //@Column String  gitRefsUrl;
  //@Column String  treesUrl;
  //@Column String  statusesUrl;
  //@Column String  languagesUrl;
  //@Column String  stargazersUrl;
  //@Column String  contributorsUrl;
  //@Column String  subscribersUrl;
  //@Column String  subscriptionUrl;
  //@Column String  commitsUrl;
  //@Column String  gitCommitsUrl;
  //@Column String  commentsUrl;
  //@Column String  issueCommentUrl;
  //@Column String  contentsUrl;
  //@Column String  compareUrl;
  //@Column String  mergesUrl;
  //@Column String  archiveUrl;
  //@Column String  downloadsUrl;
  //@Column String  issuesUrl;
  //@Column String  pullsUrl;
  //@Column String  milestonesUrl;
  //@Column String  notificationsUrl;
  //@Column String  labelsUrl;
  //@Column String  releasesUrl;
  //@Column String  deploymentsUrl;
  //@Column String  createdAt;
  //@Column String  pushedAt;
  //@Column String  gitUrl;
  //@Column String  sshUrl;
  //@Column String  cloneUrl;
  //@Column String  svnUrl;
  //@Column String  homepage;
  //@Column String  stargazersCount;
  //@Column String  watchersCount;
  //@Column String  language;
  //@Column String  forksCount;
  //@Column String  mirrorUrl;
  //@Column String  openIssuesCount;
  //@Column String  defaultBranch;
  //@Column boolean _private;
  //@Column boolean fork;
  //@Column boolean hasIssues;
  //@Column boolean hasDownloads;
  //@Column boolean hasWiki;
  //@Column boolean hasPages;
  //@Column long    size;
  //@Column long    openIssues;
}
