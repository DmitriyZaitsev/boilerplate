package boilerplate.usecase;

import boilerplate.data.ExecutionThread;
import boilerplate.data.PostExecutionThread;
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
public abstract class UseCase {
  private final ExecutionThread     mExecutionThread;
  private final PostExecutionThread mPostExecutionThread;
  private Subscription mSubscription = Subscriptions.empty();

  UseCase(ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
    mExecutionThread = executionThread;
    mPostExecutionThread = postExecutionThread;
  }

  protected abstract Observable createObservable();

  @SuppressWarnings("unchecked") public void execute(Subscriber subscriber) {
    mSubscription = createObservable().subscribeOn(mExecutionThread.getScheduler())
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
