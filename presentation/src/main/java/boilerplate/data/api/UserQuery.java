package boilerplate.data.api;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 21:41
 */
public final class UserQuery {
  private final String user;

  public UserQuery(String user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "user:" + user;
  }
}
