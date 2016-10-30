package boilerplate.data;

import boilerplate.data.api.entity.Owner;
import boilerplate.data.api.entity.Repository;
import boilerplate.domain.OwnerDto;
import boilerplate.domain.RepositoryDto;
import javax.inject.Inject;
import viper.Mapper;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 22:35
 */
public final class CloudDataMapper extends Mapper<Repository, RepositoryDto> {

  @Inject
  CloudDataMapper() {
  }

  private static OwnerDto toOwnerDto(Owner entity) {
    return OwnerDto.builder()
        .login(entity.getLogin())
        .avatarUrl(entity.getAvatarUrl())
        .build();
  }

  @Override
  public RepositoryDto map(Repository entity) {
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
