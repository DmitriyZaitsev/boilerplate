package boilerplate.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Feb-13, 22:40
 */
abstract class UseCase<P, R> {
  private final Scheduler mJobScheduler;
  private final Scheduler mPostExecutionScheduler;
  private Subscription mSubscription = Subscriptions.empty();

  UseCase(Scheduler jobScheduler, Scheduler postExecutionScheduler) {
    mJobScheduler = jobScheduler;
    mPostExecutionScheduler = postExecutionScheduler;
  }

  protected abstract Observable<R> createObservable(P param);

  public final void execute(Subscriber<? super R> subscriber, P param) {
    mSubscription = createObservable(param).subscribeOn(mJobScheduler)
        .observeOn(mPostExecutionScheduler)
        .subscribe(subscriber);
  }

  public void unsubscribe() {
    if (mSubscription.isUnsubscribed()) {
      return;
    }

    mSubscription.unsubscribe();
  }
}
