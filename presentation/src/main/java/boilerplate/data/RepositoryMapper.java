package boilerplate.data;

import boilerplate.data.cache.db.GithubRepository;
import boilerplate.data.entity.Repository;
import viper.Mapper;
import javax.inject.Inject;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 03:20
 */
public final class RepositoryMapper extends Mapper<Repository, GithubRepository> {

  @Inject RepositoryMapper() {
  }

  @Override public GithubRepository map(Repository repo) {
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
