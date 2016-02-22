package boilerplate.presentation.model;

import lombok.Builder;
import lombok.Value;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 23:07
 */
@Value
@Builder
public final class Repository {
  String name;
  Owner  owner;
  String description;
  long   watchers;
  long   forks;
  String htmlUrl;
  String updatedAt;
}
