package boilerplate.data;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 21:36
 */
public enum Sort {
  STARS, FORKS, UPDATED;

  @Override public String toString() {
    return name().toLowerCase();
  }
}
