package boilerplate.data.api;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 21:38
 */
@SuppressWarnings("unused")
public enum Order {
  ASC, DESC;

  @Override public String toString() {
    return name().toLowerCase();
  }
}
