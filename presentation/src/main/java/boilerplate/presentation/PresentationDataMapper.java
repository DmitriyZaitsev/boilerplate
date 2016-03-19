package boilerplate.presentation;

import boilerplate.domain.dto.OwnerDto;
import boilerplate.domain.dto.RepositoryDto;
import boilerplate.presentation.model.Owner;
import boilerplate.presentation.model.Repository;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-22, 23:09
 */
public final class PresentationDataMapper {
  private static Owner toOwner(OwnerDto dto) {
    return Owner.builder()
        .avatarUrl(dto.getAvatarUrl())
        .login(dto.getLogin())
        .build();
  }

  public static Repository toRepository(RepositoryDto dto) {
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
