package boilerplate.presentation.model;

import lombok.Builder;
import lombok.ToString;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 23:08
 */
@Builder
@ToString
public final class Owner {
  public final String avatarUrl;
  public final String login;
}
