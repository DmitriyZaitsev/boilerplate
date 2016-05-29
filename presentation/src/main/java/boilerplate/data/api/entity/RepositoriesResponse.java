package boilerplate.data.api.entity;

import java.util.List;
import lombok.Getter;

@Getter
public final class RepositoriesResponse {
  private final List<Repository> items;

  public RepositoriesResponse(List<Repository> items) {
    this.items = items;
  }
}
