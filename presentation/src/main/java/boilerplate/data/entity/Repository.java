package boilerplate.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-14, 00:14
 */
@ToString @Getter
public final class Repository {
  @Expose @SerializedName("id")                long    id;
  @Expose @SerializedName("name")              String  name;
  @Expose @SerializedName("full_name")         String  fullName;
  @Expose @SerializedName("owner")             Owner   owner;
  @Expose @SerializedName("html_url")          String  htmlUrl;
  @Expose @SerializedName("description")       String  description;
  @Expose @SerializedName("url")               String  url;
  @Expose @SerializedName("forks_url")         String  forksUrl;
  @Expose @SerializedName("keys_url")          String  keysUrl;
  @Expose @SerializedName("collaborators_url") String  collaboratorsUrl;
  @Expose @SerializedName("teams_url")         String  teamsUrl;
  @Expose @SerializedName("hooks_url")         String  hooksUrl;
  @Expose @SerializedName("issue_events_url")  String  issueEventsUrl;
  @Expose @SerializedName("events_url")        String  eventsUrl;
  @Expose @SerializedName("assignees_url")     String  assigneesUrl;
  @Expose @SerializedName("branches_url")      String  branchesUrl;
  @Expose @SerializedName("tags_url")          String  tagsUrl;
  @Expose @SerializedName("blobs_url")         String  blobsUrl;
  @Expose @SerializedName("git_tags_url")      String  gitTagsUrl;
  @Expose @SerializedName("git_refs_url")      String  gitRefsUrl;
  @Expose @SerializedName("trees_url")         String  treesUrl;
  @Expose @SerializedName("statuses_url")      String  statusesUrl;
  @Expose @SerializedName("languages_url")     String  languagesUrl;
  @Expose @SerializedName("stargazers_url")    String  stargazersUrl;
  @Expose @SerializedName("contributors_url")  String  contributorsUrl;
  @Expose @SerializedName("subscribers_url")   String  subscribersUrl;
  @Expose @SerializedName("subscription_url")  String  subscriptionUrl;
  @Expose @SerializedName("commits_url")       String  commitsUrl;
  @Expose @SerializedName("git_commits_url")   String  gitCommitsUrl;
  @Expose @SerializedName("comments_url")      String  commentsUrl;
  @Expose @SerializedName("issue_comment_url") String  issueCommentUrl;
  @Expose @SerializedName("contents_url")      String  contentsUrl;
  @Expose @SerializedName("compare_url")       String  compareUrl;
  @Expose @SerializedName("merges_url")        String  mergesUrl;
  @Expose @SerializedName("archive_url")       String  archiveUrl;
  @Expose @SerializedName("downloads_url")     String  downloadsUrl;
  @Expose @SerializedName("issues_url")        String  issuesUrl;
  @Expose @SerializedName("pulls_url")         String  pullsUrl;
  @Expose @SerializedName("milestones_url")    String  milestonesUrl;
  @Expose @SerializedName("notifications_url") String  notificationsUrl;
  @Expose @SerializedName("labels_url")        String  labelsUrl;
  @Expose @SerializedName("releases_url")      String  releasesUrl;
  @Expose @SerializedName("deployments_url")   String  deploymentsUrl;
  @Expose @SerializedName("created_at")        String  createdAt;
  @Expose @SerializedName("updated_at")        String  updatedAt;
  @Expose @SerializedName("pushed_at")         String  pushedAt;
  @Expose @SerializedName("git_url")           String  gitUrl;
  @Expose @SerializedName("ssh_url")           String  sshUrl;
  @Expose @SerializedName("clone_url")         String  cloneUrl;
  @Expose @SerializedName("svn_url")           String  svnUrl;
  @Expose @SerializedName("homepage")          String  homepage;
  @Expose @SerializedName("stargazers_count")  String  stargazersCount;
  @Expose @SerializedName("watchers_count")    String  watchersCount;
  @Expose @SerializedName("language")          String  language;
  @Expose @SerializedName("forks_count")       String  forksCount;
  @Expose @SerializedName("mirror_url")        String  mirrorUrl;
  @Expose @SerializedName("open_issues_count") String  openIssuesCount;
  @Expose @SerializedName("default_branch")    String  defaultBranch;
  @Expose @SerializedName("private")           boolean _private;
  @Expose @SerializedName("fork")              boolean fork;
  @Expose @SerializedName("has_issues")        boolean hasIssues;
  @Expose @SerializedName("has_downloads")     boolean hasDownloads;
  @Expose @SerializedName("has_wiki")          boolean hasWiki;
  @Expose @SerializedName("has_pages")         boolean hasPages;
  @Expose @SerializedName("size")              long    size;
  @Expose @SerializedName("forks")             long    forks;
  @Expose @SerializedName("open_issues")       long    openIssues;
  @Expose @SerializedName("watchers")          long    watchers;
}
