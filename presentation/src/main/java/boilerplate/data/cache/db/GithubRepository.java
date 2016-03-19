package boilerplate.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-19, 17:59
 */
@Table(database = GithubDatabase.class, name = "repository")
@Setter
@ToString
public final class GithubRepository extends BaseModel {
  @PrimaryKey long   id;
  @Column     String name;
  @Column     String description;
  @Column     String htmlUrl;
  @Column     String updatedAt;
  @Column     long   watchers;
  @Column     long   forks;

  @ForeignKey(saveForeignKeyModel = false) ForeignKeyContainer<GithubOwner> ownerId;

  /** Example of setting the model for the owner. */
  public void owner(GithubOwner owner) {
    ownerId = FlowManager.getContainerAdapter(GithubOwner.class)
        .toForeignKeyContainer(owner);
  }

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
