package boilerplate;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-25, 01:32
 */
public final class TestUtils {
  public static int lombokHashCode(Object... objects) {
    int hashCode = 1;
    for (Object o : objects) {
      hashCode = hashCode * 59 + (o == null ? 1 : o.hashCode());
    }
    return hashCode;
  }
}
