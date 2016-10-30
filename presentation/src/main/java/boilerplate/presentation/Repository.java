package boilerplate.presentation;

import lombok.Builder;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 23:07
 */
@Builder
@ToString
public final class Repository {
  public final String name;
  public final Owner  owner;
  public final String description;
  public final long   watchers;
  public final long   forks;
  public final String htmlUrl;
  public final String updatedAt;
}
