package boilerplate.data;

import android.support.annotation.NonNull;
import boilerplate.data.cache.db.GithubOwner;
import boilerplate.data.cache.db.GithubRepository;
import boilerplate.data.entity.Owner;
import boilerplate.data.entity.Repository;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 03:20
 */
public final class DbDataMapper {
  @NonNull static GithubOwner toOwner(final Owner owner) {
    final GithubOwner githubOwner;
    githubOwner = new GithubOwner();
    githubOwner.setId(owner.getId());
    githubOwner.setAvatarUrl(owner.getAvatarUrl());
    githubOwner.setLogin(owner.getLogin());
    return githubOwner;
  }

  @NonNull static GithubRepository toRepository(final Repository repo) {
    final GithubRepository repository = new GithubRepository();
    repository.setId(repo.getId());
    repository.setName(repo.getName());
    repository.setDescription(repo.getDescription());
    repository.setForks(repo.getForks());
    repository.setHtmlUrl(repo.getHtmlUrl());
    repository.setUpdatedAt(repo.getUpdatedAt());
    repository.setWatchers(repo.getWatchers());
    return repository;
  }
}
