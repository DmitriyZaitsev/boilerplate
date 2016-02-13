package boilerplate.data;

import rx.Observable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 23:02
 */
public interface Repository {
  Observable<String> getUsersRepositories(String user);
}
