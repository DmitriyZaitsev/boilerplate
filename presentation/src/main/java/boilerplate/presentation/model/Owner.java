package boilerplate.presentation.model;

import lombok.Builder;
import lombok.Value;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 23:08
 */
@Value
@Builder
public final class Owner {
  String avatarUrl;
  String login;
}
