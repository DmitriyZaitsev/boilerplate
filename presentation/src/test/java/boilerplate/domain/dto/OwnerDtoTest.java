package boilerplate.domain.dto;

import boilerplate.TestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-24, 22:50
 */
public class OwnerDtoTest {
  private static final String AVATAR_URL = "www.example.com";
  private static final String LOGIN      = "Steven Marshall";
  private OwnerDto mOwnerDto;

  @Before public void setUp() {
    mOwnerDto = OwnerDto.builder()
        .avatarUrl(AVATAR_URL)
        .login(LOGIN)
        .build();
  }

  @Test public void testEquals() {
    assertThat(mOwnerDto).isEqualTo(mOwnerDto)
        .isEqualTo(new OwnerDto(AVATAR_URL, LOGIN))
        .isNotEqualTo(new OwnerDto(null, LOGIN))
        .isNotEqualTo(new OwnerDto(AVATAR_URL, null))
        .isNotEqualTo(new Object());
  }

  @Test public void testHashCode() {
    final int expected = TestUtils.lombokHashCode(AVATAR_URL, LOGIN);
    assertThat(mOwnerDto.hashCode()).isEqualTo(expected);
  }

  @Test public void testProperties() {
    assertThat(mOwnerDto.getAvatarUrl()).isEqualTo(AVATAR_URL);
    assertThat(mOwnerDto.getLogin()).isEqualTo(LOGIN);
  }
}