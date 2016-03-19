package boilerplate.data.api;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 21:36
 */
@SuppressWarnings("unused")
public enum Sort {
  STARS, FORKS, UPDATED;

  @Override public String toString() {
    return name().toLowerCase();
  }
}
