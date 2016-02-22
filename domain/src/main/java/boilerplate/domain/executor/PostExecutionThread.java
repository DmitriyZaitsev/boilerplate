package boilerplate.domain.executor;

import rx.Scheduler;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:43
 */
public interface PostExecutionThread {
  Scheduler getScheduler();
}
