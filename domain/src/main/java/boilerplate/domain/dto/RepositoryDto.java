package boilerplate.domain.dto;

import lombok.Builder;
import lombok.Value;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 22:11
 */
@Value
@Builder
public final class RepositoryDto {
  String   name;
  OwnerDto owner;
  String   description;
  long     watchers;
  long     forks;
  String   htmlUrl;
  String   updatedAt;
}
