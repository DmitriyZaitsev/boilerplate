package boilerplate.domain.dto;

import boilerplate.TestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-24, 23:59
 */
public class DataRepositoryDtoTest {
  private static final String   NAME        = "Daniel Valdez";
  private static final OwnerDto OWNER_DTO   = new OwnerDto("www.example.com", "Steven Marshall");
  private static final String   DESCRIPTION = "Default description";
  private static final long     WATCHERS    = 100500;
  private static final long     FORKS       = 567;
  private static final String   HTML_URL    = "www.htmlurl.com";
  private static final String   UPDATED_AT  = "_";
  private RepositoryDto mRepositoryDto;

  @Before public void setUp() {
    mRepositoryDto = RepositoryDto.builder()
        .name(NAME)
        .owner(OWNER_DTO)
        .description(DESCRIPTION)
        .watchers(WATCHERS)
        .forks(FORKS)
        .htmlUrl(HTML_URL)
        .updatedAt(UPDATED_AT)
        .build();
  }

  @Test public void testEquals() {
    assertThat(mRepositoryDto).isEqualTo(mRepositoryDto)
        .isEqualTo(new RepositoryDto(NAME, OWNER_DTO, DESCRIPTION, WATCHERS, FORKS, HTML_URL, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(null, OWNER_DTO, DESCRIPTION, WATCHERS, FORKS, HTML_URL, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(NAME, null, DESCRIPTION, WATCHERS, FORKS, HTML_URL, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(NAME, OWNER_DTO, null, WATCHERS, FORKS, HTML_URL, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(NAME, OWNER_DTO, DESCRIPTION, -1, FORKS, HTML_URL, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(NAME, OWNER_DTO, DESCRIPTION, WATCHERS, -1, HTML_URL, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(NAME, OWNER_DTO, DESCRIPTION, WATCHERS, FORKS, null, UPDATED_AT))
        .isNotEqualTo(new RepositoryDto(NAME, OWNER_DTO, DESCRIPTION, WATCHERS, FORKS, HTML_URL, null))
        .isNotEqualTo(new RepositoryDto(null, null, null, -1, -1, null, null))
        .isNotEqualTo(new Object());
  }

  @Test public void testHashCode() {
    assertThat(mRepositoryDto.hashCode()).isEqualTo(
        TestUtils.lombokHashCode(NAME, OWNER_DTO, DESCRIPTION, WATCHERS, FORKS, HTML_URL, UPDATED_AT));
  }

  @Test public void testProperties() {
    assertThat(mRepositoryDto.getName()).isEqualTo(NAME);
    assertThat(mRepositoryDto.getOwner()).isEqualTo(OWNER_DTO);
    assertThat(mRepositoryDto.getDescription()).isEqualTo(DESCRIPTION);
    assertThat(mRepositoryDto.getWatchers()).isEqualTo(WATCHERS);
    assertThat(mRepositoryDto.getForks()).isEqualTo(FORKS);
    assertThat(mRepositoryDto.getHtmlUrl()).isEqualTo(HTML_URL);
    assertThat(mRepositoryDto.getUpdatedAt()).isEqualTo(UPDATED_AT);
  }
}