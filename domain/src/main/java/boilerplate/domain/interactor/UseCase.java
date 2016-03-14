package boilerplate.domain.interactor;

import boilerplate.domain.executor.ExecutionThread;
import boilerplate.domain.executor.PostExecutionThread;
import rx.Observable;
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
  private final ExecutionThread     mExecutionThread;
  private final PostExecutionThread mPostExecutionThread;
  private Subscription mSubscription = Subscriptions.empty();

  UseCase(ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
    mExecutionThread = executionThread;
    mPostExecutionThread = postExecutionThread;
  }

  protected abstract Observable<R> createObservable(P param);

  public final void execute(Subscriber<? super R> subscriber, P param) {
    mSubscription = createObservable(param).subscribeOn(mExecutionThread.getScheduler())
        .observeOn(mPostExecutionThread.getScheduler())
        .subscribe(subscriber);
  }

  public void unsubscribe() {
    if (mSubscription.isUnsubscribed()) {
      return;
    }

    mSubscription.unsubscribe();
  }
}
