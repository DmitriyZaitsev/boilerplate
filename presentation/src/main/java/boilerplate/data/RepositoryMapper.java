package boilerplate.data;

import boilerplate.data.api.entity.Repository;
import boilerplate.data.cache.db.GithubRepository;
import javax.inject.Inject;
import viper.Mapper;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-20, 03:20
 */
public final class RepositoryMapper extends Mapper<Repository, GithubRepository> {
  private final OwnerMapper mapper;

  @Inject
  RepositoryMapper(OwnerMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public GithubRepository map(Repository repo) {
    final GithubRepository repository = new GithubRepository();
    repository.setId(repo.getId());
    repository.setName(repo.getName());
    repository.setDescription(repo.getDescription());
    repository.setForks(repo.getForks());
    repository.setHtmlUrl(repo.getHtmlUrl());
    repository.setUpdatedAt(repo.getUpdatedAt());
    repository.setWatchers(repo.getWatchers());
    repository.setOwner(mapper.map(repo.getOwner()));
    return repository;
  }
}
