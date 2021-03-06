package boilerplate.data;

import boilerplate.data.api.entity.Owner;
import boilerplate.data.cache.db.GithubOwner;
import javax.inject.Inject;
import viper.Mapper;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 02:51
 */
public final class OwnerMapper extends Mapper<Owner, GithubOwner> {
  @Inject
  OwnerMapper() {
  }

  @Override
  public GithubOwner map(Owner owner) {
    final GithubOwner githubOwner = new GithubOwner();
    githubOwner.setId(owner.getId());
    githubOwner.setAvatarUrl(owner.getAvatarUrl());
    githubOwner.setLogin(owner.getLogin());
    return githubOwner;
  }
}
