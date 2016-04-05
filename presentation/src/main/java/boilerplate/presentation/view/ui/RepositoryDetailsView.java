package boilerplate.presentation.view.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import boilerplate.databinding.ViewDetailsBinding;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.presenter.DetailsScreenPresenter;
import boilerplate.presentation.view.DetailsView;
import boilerplate.presentation.view.MainActivity;
import javax.inject.Inject;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 03:48
 */
public final class RepositoryDetailsView extends LinearLayout implements DetailsView {

  @Inject DetailsScreenPresenter mPresenter;
  private ViewDetailsBinding     mBinding;

  public RepositoryDetailsView(final Context context) {
    this(context, null);
  }

  public RepositoryDetailsView(final Context context, final AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RepositoryDetailsView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    (MainActivity.getComponent(context)).inject(this);
  }

  @Override public void bind(final Repository repository) {
    mBinding.setRepository(repository);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    mBinding = ViewDetailsBinding.bind(this);
  }
}
