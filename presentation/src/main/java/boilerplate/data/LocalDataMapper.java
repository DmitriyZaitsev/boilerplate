package boilerplate.data;

import boilerplate.data.cache.db.GithubOwner;
import boilerplate.data.cache.db.GithubRepository;
import boilerplate.domain.dto.OwnerDto;
import boilerplate.domain.dto.RepositoryDto;
import javax.inject.Inject;
import viper.Mapper;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-05, 17:20
 */
public final class LocalDataMapper extends Mapper<GithubRepository, RepositoryDto> {

  @Inject LocalDataMapper() {
  }

  private static OwnerDto toOwnerDto(GithubOwner entity) {
    return entity == null ? (OwnerDto.builder()).build() : OwnerDto.builder()
        .login(entity.getLogin())
        .avatarUrl(entity.getAvatarUrl())
        .build();
  }

  @Override public RepositoryDto map(GithubRepository entity) {
    return RepositoryDto.builder()
        .name(entity.getName())
        .description(entity.getDescription())
        .owner(toOwnerDto(entity.getOwner()))
        .forks(entity.getForks())
        .htmlUrl(entity.getHtmlUrl())
        .updatedAt(entity.getUpdatedAt())
        .watchers(entity.getWatchers())
        .build();
  }
}
