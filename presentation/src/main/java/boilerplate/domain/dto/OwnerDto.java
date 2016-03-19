package boilerplate.domain.dto;

import lombok.Builder;
import lombok.Value;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 22:36
 */
@Value
@Builder
public final class OwnerDto {
  private String avatarUrl;
  private String login;
}
