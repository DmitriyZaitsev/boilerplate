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
  private String   name;
  private OwnerDto owner;
  private String   description;
  private long     watchers;
  private long     forks;
  private String   htmlUrl;
  private String   updatedAt;
}
