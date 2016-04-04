package boilerplate.data;

import boilerplate.data.entity.Owner;
import boilerplate.data.entity.Repository;
import boilerplate.domain.dto.OwnerDto;
import boilerplate.domain.dto.RepositoryDto;
import boilerplate.viper.Mapper;
import javax.inject.Inject;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 22:35
 */
public final class DomainDataMapper extends Mapper<Repository, RepositoryDto> {

  @Inject DomainDataMapper() {
  }

  private static OwnerDto toOwnerDto(Owner entity) {
    return OwnerDto.builder()
        .login(entity.getLogin())
        .avatarUrl(entity.getAvatarUrl())
        .build();
  }

  @Override public RepositoryDto map(Repository entity) {
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
