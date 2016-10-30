package boilerplate.presentation;

import boilerplate.domain.OwnerDto;
import boilerplate.domain.RepositoryDto;
import javax.inject.Inject;
import viper.Mapper;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 23:09
 */
public final class PresentationDataMapper extends Mapper<RepositoryDto, Repository> {

  @Inject
  PresentationDataMapper() {
  }

  private static Owner toOwner(OwnerDto dto) {
    return Owner.builder()
        .avatarUrl(dto.getAvatarUrl())
        .login(dto.getLogin())
        .build();
  }

  @Override
  public Repository map(RepositoryDto dto) {
    return Repository.builder()
        .description(dto.getDescription())
        .forks(dto.getForks())
        .htmlUrl(dto.getHtmlUrl())
        .name(dto.getName())
        .owner(toOwner(dto.getOwner()))
        .updatedAt(dto.getUpdatedAt())
        .watchers(dto.getWatchers())
        .build();
  }
}
