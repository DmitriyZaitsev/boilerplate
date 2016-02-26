package boilerplate.data;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 21:41
 */
public final class UserQuery {
  private final String mUser;

  public UserQuery(String user) {
    mUser = user;
  }

  @Override public String toString() {
    return "user:" + mUser;
  }
}
