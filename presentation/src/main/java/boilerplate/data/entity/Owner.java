package boilerplate.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:12
 */
@ToString @Getter
public final class Owner {
  @Expose @SerializedName("received_events_url") String receivedEventsUrl;
  @Expose @SerializedName("organizations_url")   String organizationsUrl;
  @Expose @SerializedName("avatar_url")          String avatarUrl;
  @Expose @SerializedName("gravatar_id")         String gravatarId;
  @Expose @SerializedName("gists_url")           String gistsUrl;
  @Expose @SerializedName("starred_url")         String starredUrl;
  @Expose @SerializedName("site_admin")          boolean siteAdmin;
  @Expose @SerializedName("type")                String type;
  @Expose @SerializedName("url")                 String url;
  @Expose @SerializedName("id")                  long id;
  @Expose @SerializedName("html_url")            String htmlUrl;
  @Expose @SerializedName("following_url")       String followingUrl;
  @Expose @SerializedName("events_url")          String eventsUrl;
  @Expose @SerializedName("login")               String login;
  @Expose @SerializedName("subscriptions_url")   String subscriptionsUrl;
  @Expose @SerializedName("repos_url")           String reposUrl;
  @Expose @SerializedName("followers_url")       String followersUrl;
}
