//@formatter:off
package boilerplate.data;

import okhttp3.ResponseBody;import retrofit2.Call;import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 16:48
 */
public interface GitHubApi {
  //@DELETE("/repos/{ownerId}/{repoId}/collaborators/{user}") Response deleteCollaboratorByUser(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("user") String user);
  //
  //@DELETE("/gists/{id}/comments/{commentId}") Response deleteCommentByCommentId(@Path("id") String id,
  //    @Path("commentId") String commentId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/pulls/comments/{number}") Response deleteCommentByNumber(
  //    @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/contents/{path}") Response deleteContentByPath(@Path("ownerId") String ownerId,
  //    @Path("path") String path, @Path("repoId") String repoId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/downloads/{downloadId}") Response deleteDownloadByDownloadId(
  //    @Path("ownerId") String ownerId, @Path("downloadId") String downloadId, @Path("repoId") String repoId);
  //
  //@DELETE("/user/emails") Response deleteEmails();
  //
  //@DELETE("/user/following/{userId}") Response deleteFollowingByUserId(@Path("userId") String userId);
  //
  //@DELETE("/gists/{id}") Response deleteGistById(@Path("id") String id);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/hooks/{hookId}") Response deleteHookByHookId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("hookId") String hookId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/issues/comments/{commentId}") Response deleteIssuesCommentByCommentId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("commentId") String commentId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/keys/{keyId}") Response deleteKeyByKeyId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("keyId") String keyId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/issues/{number}/labels/{name}") Response deleteLabelByName(
  //    @Path("ownerId") String ownerId, @Path("name") String name, @Path("number") String number,
  //    @Path("repoId") String repoId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/issues/{number}/labels") Response deleteLabels(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@DELETE("/orgs/{orgId}/members/{userId}") Response deleteMemberByUserId(@Path("orgId") String orgId,
  //    @Path("userId") String userId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/milestones/{number}") Response deleteMilestoneByNumber(
  //    @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId);
  //
  //@DELETE("/orgs/{orgId}/public_members/{userId}") Response deletePublicMemberByUserId(@Path("orgId") String orgId,
  //    @Path("userId") String userId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/git/refs/{heads}/{branch}") Response deleteRefByHeadsAndBranch(
  //    @Path("ownerId") String ownerId, @Path("heads") String heads, @Path("branch") String branch,
  //    @Path("repoId") String repoId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}") Response deleteRepoByOwnerIdAndRepoId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/comments/{commentId}") Response deleteRepoIdCommentByCommentId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("commentId") String commentId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/labels/{name}") Response deleteRepoIdLabelByName(@Path("ownerId") String ownerId,
  //    @Path("name") String name, @Path("repoId") String repoId);
  //
  //@DELETE("/repos/{ownerId}/{repoId}/subscription") Response deleteRepoIdSubscription(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@DELETE("/gists/{id}/star") Response deleteStar(@Path("id") String id);
  //
  //@DELETE("/user/starred/{ownerId}/{repoId}") Response deleteStarredByOwnerIdAndRepoId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@DELETE("/notifications/threads/{id}/subscription") Response deleteSubscription(@Path("id") String id);
  //
  //@DELETE("/user/subscriptions/{ownerId}/{repoId}") Response deleteSubscriptionByOwnerIdAndRepoId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId);
  //
  //@DELETE("/teams/{teamsId}") Response deleteTeamByTeamsId(@Path("teamsId") String teamsId);
  //
  //@DELETE("/teams/{teamsId}/members/{userId}") Response deleteTeamsIdMemberByUserId(@Path("userId") String userId,
  //    @Path("teamsId") String teamsId);
  //
  //@DELETE("/user/keys/{keyId}") Response deleteUserKeyByKeyId(@Path("keyId") String keyId);
  //
  //@GET("/repos/{ownerId}/{repoId}/assignees/{assignee}") Response getAssigneeByAssignee(@Path("ownerId") String ownerId,
  //    @Path("assignee") String assignee, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/assignees") Response getAssignees(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/blobs/{shaCode}") Response getBlobByShaCode(@Path("ownerId") String ownerId,
  //    @Path("shaCode") String shaCode, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/branches/{branchId}") Response getBranchByBranchId(@Path("branchId") String branchId,
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/branches") Response getBranches(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/search/code") Response getCode(@Query("sort") String sort, @Query("order") String order, @Query("q") String q);
  //
  //@GET("/repos/{ownerId}/{repoId}/stats/code_frequency") Response getCodeFrequency(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/collaborators/{user}") Response getCollaboratorByUser(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("user") String user);
  //
  //@GET("/repos/{ownerId}/{repoId}/collaborators") Response getCollaborators(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/gists/{id}/comments/{commentId}") Response getCommentByCommentId(@Path("id") String id,
  //    @Path("commentId") String commentId);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/comments/{number}") Response getCommentByNumber(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/gists/{id}/comments") Response getComments(@Path("id") String id);
  //
  //@GET("/repos/{ownerId}/{repoId}/stats/commit_activity") Response getCommitActivity(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/commits/{shaCode}") Response getCommitByShaCode(@Path("ownerId") String ownerId,
  //    @Path("shaCode") String shaCode, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/{number}/commits") Response getCommits(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/contents/{path}") Response getContentByPath(@Query("ref") String ref,
  //    @Path("ownerId") String ownerId, @Query("path") String path, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/contributors") Response getContributors(@Query("anon") String anon,
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/downloads/{downloadId}") Response getDownloadByDownloadId(
  //    @Path("ownerId") String ownerId, @Path("downloadId") String downloadId, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/downloads") Response getDownloads(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/user/emails") Response getEmails();
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/events/{eventId}") Response getEventByEventId(@Path("eventId") String eventId,
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId);
  //
  //@GET("/events") Response getEvents();
  //
  //@GET("/user/{userId}/events/orgs/{orgId}") Response getEventsOrgByOrgId(@Path("orgId") String orgId,
  //    @Path("userId") String userId);
  //
  //@GET("/user/{userId}/events/public") Response getEventsPublic(@Path("userId") String userId);
  //
  //@GET("/feeds") Response getFeeds();
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/{number}/files") Response getFiles(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/user/following") Response getFollowing();
  //
  //@GET("/users/{userId}/following/{targetUserId}") Response getFollowingByTargetUserId(
  //    @Path("targetUserId") String targetUserId, @Path("userId") String userId);
  //
  //@GET("/user/following/{userId}") Response getFollowingByUserId(@Path("userId") String userId);
  //
  //@GET("/repos/{ownerId}/{repoId}/forks") Response getForks(@Query("sort") String sort, @Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/gists/{id}") Response getGistById(@Path("id") String id);
  //
  //@GET("/gists") Response getGists(@Query("since") String since);
  //
  //@GET("/repos/{ownerId}/{repoId}/hooks/{hookId}") Response getHookByHookId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("hookId") String hookId);
  //
  //@GET("/repos/{ownerId}/{repoId}/hooks") Response getHooks(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/{number}") Response getIssueByNumber(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/issues") Response getIssues(@Query("sort") String sort, @Query("direction") String direction,
  //    @Query("labels") String labels, @Query("state") String state, @Query("since") String since,
  //    @Query("filter") String filter);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/comments/{commentId}") Response getIssuesCommentByCommentId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("commentId") String commentId);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/comments") Response getIssuesComments(@Query("sort") String sort,
  //    @Query("direction") String direction, @Path("ownerId") String ownerId, @Path("repoId") String repoId,
  //    @Query("since") String since);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/events") Response getIssuesEvents(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/keys/{keyId}") Response getKeyByKeyId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("keyId") String keyId);
  //
  //@GET("/repos/{ownerId}/{repoId}/keys") Response getKeys(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/labels/{name}") Response getLabelByName(@Path("ownerId") String ownerId,
  //    @Path("name") String name, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/{number}/labels") Response getLabels(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/languages") Response getLanguages(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/teams/{teamsId}/members/{userId}") Response getMemberByUserId(@Path("userId") String userId,
  //    @Path("teamsId") String teamsId);
  //
  //@GET("/orgs/{orgId}/members") Response getMembers(@Path("orgId") String orgId);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/{number}/merge") Response getMerge(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/meta") Response getMeta();
  //
  //@GET("/repos/{ownerId}/{repoId}/milestones/{number}") Response getMilestoneByNumber(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/milestones") Response getMilestones(@Query("sort") String sort,
  //    @Query("direction") String direction, @Path("ownerId") String ownerId, @Query("state") String state,
  //    @Path("repoId") String repoId);
  //
  //@GET("/notifications") Response getNotifications(@Query("participating") String participating,
  //    @Query("since") String since, @Query("all") String all);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/{number}/comments") Response getNumberComments(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/{number}/events/{eventId}") Response getNumberEventByEventId(
  //    @Path("eventId") String eventId, @Path("ownerId") String ownerId, @Path("number") String number,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues/{number}/events") Response getNumberEvents(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/milestones/{number}/labels") Response getNumberLabels(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/orgs/{orgId}") Response getOrgByOrgId(@Path("orgId") String orgId);
  //
  //@GET("/orgs/{orgId}/events") Response getOrgIdEvents(@Path("orgId") String orgId);
  //
  //@GET("/orgs/{orgId}/issues") Response getOrgIdIssues(@Path("orgId") String orgId, @Query("sort") String sort,
  //    @Query("direction") String direction, @Query("labels") String labels, @Query("state") String state,
  //    @Query("since") String since, @Query("filter") String filter);
  //
  //@GET("/user/orgs") Response getOrgs();
  //
  //@GET("/networks/{ownerId}/{repoId}/events") Response getOwnerIdRepoIdEvents(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/stats/participation") Response getParticipation(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/gists/public") Response getPublic(@Query("since") String since);
  //
  //@GET("/orgs/{orgId}/public_members/{userId}") Response getPublicMemberByUserId(@Path("orgId") String orgId,
  //    @Path("userId") String userId);
  //
  //@GET("/orgs/{orgId}/public_members") Response getPublicMembers(@Path("orgId") String orgId);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/{number}") Response getPullByNumber(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls") Response getPulls(@Path("ownerId") String ownerId, @Query("base") String base,
  //    @Query("state") String state, @Path("repoId") String repoId, @Query("head") String head);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/comments") Response getPullsComments(@Query("sort") String sort,
  //    @Query("direction") String direction, @Path("ownerId") String ownerId, @Path("repoId") String repoId,
  //    @Query("since") String since);
  //
  //@GET("/repos/{ownerId}/{repoId}/pulls/{number}/comments") Response getPullsNumberComments(
  //    @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/stats/punch_card") Response getPunchCard(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/rate_limit") Response getRateLimit();
  //
  //@GET("/repos/{ownerId}/{repoId}/readme") Response getReadme(@Query("ref") String ref, @Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/user/{userId}/received_events") Response getReceivedEvents(@Path("userId") String userId);
  //
  //@GET("/user/{userId}/received_events/public") Response getReceivedEventsPublic(@Path("userId") String userId);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/refs/{heads}") Response getRefByHeads(@Path("ownerId") String ownerId,
  //    @Path("heads") String heads, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/refs/{heads}/{branch}") Response getRefByHeadsAndBranch(
  //    @Path("ownerId") String ownerId, @Path("heads") String heads, @Path("branch") String branch,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/refs") Response getRefs(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}") Response getRepoByOwnerIdAndRepoId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/{archive_format}/{path}") Response getRepoByOwnerIdAndRepoIdAndArchiveFormatAndPath(
  //    @Path("archive_format") String archiveFormat, @Path("ownerId") String ownerId, @Path("path") String path,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/comments/{commentId}") Response getRepoIdCommentByCommentId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("commentId") String commentId);
  //
  //@GET("/repos/{ownerId}/{repoId}/comments") Response getRepoIdComments(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/commits/{shaCode}") Response getRepoIdCommitByShaCode(@Path("ownerId") String ownerId,
  //    @Path("shaCode") String shaCode, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/commits") Response getRepoIdCommits(@Query("author") String author,
  //    @Query("sha") String sha, @Path("ownerId") String ownerId, @Query("path") String path,
  //    @Path("repoId") String repoId, @Query("since") String since, @Query("until") String until);
  //
  //@GET("/repos/{ownerId}/{repoId}/events") Response getRepoIdEvents(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/issues") Response getRepoIdIssues(@Query("sort") String sort,
  //    @Query("direction") String direction, @Path("ownerId") String ownerId, @Query("labels") String labels,
  //    @Query("state") String state, @Path("repoId") String repoId, @Query("since") String since,
  //    @Query("filter") String filter);
  //
  //@GET("/repos/{ownerId}/{repoId}/labels") Response getRepoIdLabels(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/notifications") Response getRepoIdNotifications(@Path("ownerId") String ownerId,
  //    @Query("participating") String participating, @Path("repoId") String repoId, @Query("since") String since,
  //    @Query("all") String all);
  //
  //@GET("/repos/{ownerId}/{repoId}/subscription") Response getRepoIdSubscription(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/teams") Response getRepoIdTeams(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/orgs/{orgId}/repos") Response getRepos(@Path("orgId") String orgId, @Query("type") String type);
  //
  //@GET("/search/repositories") Response getRepositories(@Query("sort") String sort, @Query("order") String order,
  //    @Query("q") String q);
  //
  //@GET("/repositories") Response getRepositories_1(@Query("since") String since);
  //
  //@GET("/repos/{ownerId}/{repoId}/commits/{shaCode}/comments") Response getShaCodeComments(
  //    @Path("ownerId") String ownerId, @Path("shaCode") String shaCode, @Path("repoId") String repoId);
  //
  //@GET("/gists/{id}/star") Response getStar(@Path("id") String id);
  //
  //@GET("/repos/{ownerId}/{repoId}/stargazers") Response getStargazers(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/gists/starred") Response getStarred(@Query("since") String since);
  //
  //@GET("/user/starred/{ownerId}/{repoId}") Response getStarredByOwnerIdAndRepoId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/stats/contributors") Response getStatsContributors(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/statuses/{ref}") Response getStatusByRef(@Path("ref") String ref,
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/subscribers") Response getSubscribers(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/notifications/threads/{id}/subscription") Response getSubscription(@Path("id") String id);
  //
  //@GET("/user/subscriptions/{ownerId}/{repoId}") Response getSubscriptionByOwnerIdAndRepoId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId);
  //
  //@GET("/user/{userId}/subscriptions") Response getSubscriptions(@Path("userId") String userId);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/tags/{shaCode}") Response getTagByShaCode(@Path("ownerId") String ownerId,
  //    @Path("shaCode") String shaCode, @Path("repoId") String repoId);
  //
  //@GET("/repos/{ownerId}/{repoId}/tags") Response getTags(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@GET("/teams/{teamsId}") Response getTeamByTeamsId(@Path("teamsId") String teamsId);
  //
  //@GET("/orgs/{orgId}/teams") Response getTeams(@Path("orgId") String orgId);
  //
  //@GET("/teams/{teamsId}/members") Response getTeamsIdMembers(@Path("teamsId") String teamsId);
  //
  //@GET("/gitignore/templates/{language}") Response getTemplateByLanguage(@Path("language") String language);
  //
  //@GET("/gitignore/templates") Response getTemplates();
  //
  //@GET("/notifications/threads/{id}") Response getThreadById(@Path("id") String id);
  //
  //@GET("/repos/{ownerId}/{repoId}/git/trees/{shaCode}") Response getTreeByShaCode(@Query("recursive") String recursive,
  //    @Path("ownerId") String ownerId, @Path("shaCode") String shaCode, @Path("repoId") String repoId);
  //
  //@GET("/user") Response getUser();
  //
  //@GET("/user/{userId}") Response getUserByUserId(@Path("userId") String userId);
  //
  //@GET("/users/{userId}") Response getUserByUserId_1(@Path("userId") String userId);
  //
  //@GET("/user/{userId}/events") Response getUserIdEvents(@Path("userId") String userId);
  //
  //@GET("/users/{userId}/gists") Response getUserIdGists(@Path("userId") String userId, @Query("since") String since);
  //
  //@GET("/users/{userId}/keys") Response getUserIdKeys(@Path("userId") String userId);
  //
  //@GET("/user/{userId}/orgs") Response getUserIdOrgs(@Path("userId") String userId);
  //
  @GET("/users/{userId}/repos") Call<ResponseBody> getUserIdRepos(@Path("userId") String userId, @Query("type") String type);
  //
  //@GET("/user/{userId}/starred") Response getUserIdStarred(@Query("sort") String sort,
  //    @Query("direction") String direction, @Path("userId") String userId);
  //
  //@GET("/user/issues") Response getUserIssues(@Query("sort") String sort, @Query("direction") String direction,
  //    @Query("labels") String labels, @Query("state") String state, @Query("since") String since,
  //    @Query("filter") String filter);
  //
  //@GET("/user/keys/{keyId}") Response getUserKeyByKeyId(@Path("keyId") String keyId);
  //
  //@GET("/user/keys") Response getUserKeys();
  //
  //@GET("/user/repos") Response getUserRepos(@Query("type") String type);
  //
  //@GET("/user/starred") Response getUserStarred(@Query("sort") String sort, @Query("direction") String direction);
  //
  //@GET("/user/subscriptions") Response getUserSubscriptions();
  //
  //@GET("/search/users") Response getUsers(@Query("sort") String sort, @Query("order") String order,
  //    @Query("q") String q);
  //
  //@GET("/users/{userId}/orgs") Response getUsersUserIdOrgs(@Path("userId") String userId);
  //
  //@GET("/users") Response getUsers_1(@Query("since") String since);
  //
  //@GET("/repos/{ownerId}/{repoId}/watchers") Response getWatchers(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@PATCH("/gists/{id}/comments/{commentId}") Response patchCommentByCommentId(@Path("id") String id,
  //    @Path("commentId") String commentId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/pulls/comments/{number}") Response patchCommentByNumber(
  //    @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId);
  //
  //@PATCH("/gists/{id}") Response patchGistById(@Path("id") String id);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/hooks/{hookId}") Response patchHookByHookId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("hookId") String hookId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/issues/{number}") Response patchIssueByNumber(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/issues/comments/{commentId}") Response patchIssuesCommentByCommentId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("commentId") String commentId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/keys/{keyId}") Response patchKeyByKeyId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId, @Path("keyId") String keyId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/labels/{name}") Response patchLabelByName(@Path("ownerId") String ownerId,
  //    @Path("name") String name, @Path("repoId") String repoId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/milestones/{number}") Response patchMilestoneByNumber(
  //    @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId);
  //
  //@PATCH("/orgs/{orgId}") Response patchOrgByOrgId(@Path("orgId") String orgId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/pulls/{number}") Response patchPullByNumber(@Path("ownerId") String ownerId,
  //    @Path("number") String number, @Path("repoId") String repoId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/git/refs/{heads}/{branch}") Response patchRefByHeadsAndBranch(
  //    @Path("ownerId") String ownerId, @Path("heads") String heads, @Path("branch") String branch,
  //    @Path("repoId") String repoId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}") Response patchRepoByOwnerIdAndRepoId(@Path("ownerId") String ownerId,
  //    @Path("repoId") String repoId);
  //
  //@PATCH("/repos/{ownerId}/{repoId}/comments/{commentId}") Response patchRepoIdCommentByCommentId(
  //    @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Path("commentId") String commentId);
  //
  //@PATCH("/teams/{teamsId}") Response patchTeamByTeamsId(@Path("teamsId") String teamsId);
  //
  //@PATCH("/notifications/threads/{id}") Response patchThreadById(@Path("id") String id);
  //
  //@PATCH("/user") Response patchUser();
  //
  //@PATCH("/user/keys/{keyId}") Response patchUserKeyByKeyId(@Path("keyId") String keyId);

  /*@POST("/repos/{ownerId}/{repoId}/git/blobs") Response postBlobs(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/gists/{id}/comments") Response postComments(@Path("id") String id, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/git/commits") Response postCommits(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/downloads") Response postDownloads(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/user/emails") Response postEmails(@Body TypedByteArray body);

  @POST("/gists/{id}/forks") Response postForks(@Path("id") String id, @Body TypedByteArray body);

  @POST("/gists")
  Response postGists(@Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/hooks") Response postHooks(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/issues") Response postIssues(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/keys") Response postKeys(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/issues/{number}/labels") Response postLabels(@Path("ownerId") String ownerId,
      @Path("number") String number, @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/markdown") Response postMarkdown(@Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/merges") Response postMerges(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/milestones") Response postMilestones(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/issues/{number}/comments") Response postNumberComments(
      @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId,
      @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/pulls") Response postPulls(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/pulls/{number}/comments") Response postPullsNumberComments(
      @Path("ownerId") String ownerId, @Path("number") String number, @Path("repoId") String repoId,
      @Body TypedByteArray body);

  @POST("/markdown/raw") Response postRaw(@Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/git/refs") Response postRefs(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/forks") Response postRepoIdForks(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/labels") Response postRepoIdLabels(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/orgs/{orgId}/repos") Response postRepos(@Path("orgId") String orgId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/commits/{shaCode}/comments") Response postShaCodeComments(
      @Path("ownerId") String ownerId, @Path("shaCode") String shaCode, @Path("repoId") String repoId,
      @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/statuses/{ref}") Response postStatusByRef(@Path("ref") String ref,
      @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/git/tags") Response postTags(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/orgs/{orgId}/teams") Response postTeams(@Path("orgId") String orgId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/hooks/{hookId}/tests") Response postTests(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Path("hookId") String hookId, @Body TypedByteArray body);

  @POST("/repos/{ownerId}/{repoId}/git/trees") Response postTrees(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @POST("/user/keys") Response postUserKeys(@Body TypedByteArray body);

  @POST("/user/repos") Response postUserRepos(@Body TypedByteArray body);

  @PUT("/repos/{ownerId}/{repoId}/collaborators/{user}") Response putCollaboratorByUser(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Path("user") String user, @Body TypedByteArray body);

  @PUT("/repos/{ownerId}/{repoId}/contents/{path}") Response putContentByPath(@Path("ownerId") String ownerId,
      @Path("path") String path, @Path("repoId") String repoId, @Body TypedByteArray body);

  @PUT("/user/following/{userId}") Response putFollowingByUserId(@Path("userId") String userId,
      @Body TypedByteArray body);

  @PUT("/repos/{ownerId}/{repoId}/issues/{number}/labels") Response putLabels(@Path("ownerId") String ownerId,
      @Path("number") String number, @Path("repoId") String repoId, @Body TypedByteArray body);

  @PUT("/teams/{teamsId}/members/{userId}") Response putMemberByUserId(@Path("userId") String userId,
      @Path("teamsId") String teamsId, @Body TypedByteArray body);

  @PUT("/repos/{ownerId}/{repoId}/pulls/{number}/merge") Response putMerge(@Path("ownerId") String ownerId,
      @Path("number") String number, @Path("repoId") String repoId, @Body TypedByteArray body);

  @PUT("/notifications") Response putNotifications(@Body TypedByteArray body);

  @PUT("/orgs/{orgId}/public_members/{userId}") Response putPublicMemberByUserId(@Path("orgId") String orgId,
      @Path("userId") String userId, @Body TypedByteArray body);

  @PUT("/repos/{ownerId}/{repoId}/notifications") Response putRepoIdNotifications(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @PUT("/repos/{ownerId}/{repoId}/subscription") Response putRepoIdSubscription(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @PUT("/gists/{id}/star") Response putStar(@Path("id") String id, @Body TypedByteArray body);

  @PUT("/user/starred/{ownerId}/{repoId}") Response putStarredByOwnerIdAndRepoId(@Path("ownerId") String ownerId,
      @Path("repoId") String repoId, @Body TypedByteArray body);

  @PUT("/notifications/threads/{id}/subscription")
  Response putSubscription(@Path("id") String id, @Body TypedByteArray body);

  @PUT("/user/subscriptions/{ownerId}/{repoId}") Response putSubscriptionByOwnerIdAndRepoId(
      @Path("ownerId") String ownerId, @Path("repoId") String repoId, @Body TypedByteArray body);*/
}
