package boilerplate.data;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 21:38
 */
public enum Order {
  ASC, DESC;

  @Override public String toString() {
    return name().toLowerCase();
  }
}
