package boilerplate.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 17:16
 */

public final class GitHub {
  @Expose @SerializedName("current_user_url")                     String currentUserUrl;
  @Expose @SerializedName("current_user_authorizations_html_url") String currentUserAuthorizationsHtmlUrl;
  @Expose @SerializedName("authorizations_url")                   String authorizationsUrl;
  @Expose @SerializedName("code_search_url")                      String codeSearchUrl;
  @Expose @SerializedName("emails_url")                           String emailsUrl;
  @Expose @SerializedName("emojis_url")                           String emojisUrl;
  @Expose @SerializedName("events_url")                           String eventsUrl;
  @Expose @SerializedName("feeds_url")                            String feedsUrl;
  @Expose @SerializedName("followers_url")                        String followersUrl;
  @Expose @SerializedName("following_url")                        String followingUrl;
  @Expose @SerializedName("gists_url")                            String gistsUrl;
  @Expose @SerializedName("hub_url")                              String hubUrl;
  @Expose @SerializedName("issue_search_url")                     String issueSearchUrl;
  @Expose @SerializedName("issues_url")                           String issuesUrl;
  @Expose @SerializedName("keys_url")                             String keysUrl;
  @Expose @SerializedName("notifications_url")                    String notificationsUrl;
  @Expose @SerializedName("organization_repositories_url")        String organizationRepositoriesUrl;
  @Expose @SerializedName("organization_url")                     String organizationUrl;
  @Expose @SerializedName("public_gists_url")                     String publicGistsUrl;
  @Expose @SerializedName("rate_limit_url")                       String rateLimitUrl;
  @Expose @SerializedName("repository_url")                       String repositoryUrl;
  @Expose @SerializedName("repository_search_url")                String repositorySearchUrl;
  @Expose @SerializedName("current_user_repositories_url")        String currentUserRepositoriesUrl;
  @Expose @SerializedName("starred_url")                          String starredUrl;
  @Expose @SerializedName("starred_gists_url")                    String starredGistsUrl;
  @Expose @SerializedName("team_url")                             String teamUrl;
  @Expose @SerializedName("user_url")                             String userUrl;
  @Expose @SerializedName("user_organizations_url")               String userOrganizationsUrl;
  @Expose @SerializedName("user_repositories_url")                String userRepositoriesUrl;
  @Expose @SerializedName("user_search_url")                      String userSearchUrl;
}
