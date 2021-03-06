package boilerplate.data.api.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:18
 */
@SuppressWarnings("unused")
final class Permissions {
  @Expose @SerializedName("pull")  String pull;
  @Expose @SerializedName("admin") String admin;
  @Expose @SerializedName("push")  String push;
}
