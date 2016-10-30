package boilerplate.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import boilerplate.databinding.ViewDetailsBinding;
import javax.inject.Inject;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 03:48
 */
public final class RepositoryDetailsView extends LinearLayout implements DetailsView {

  @Inject DetailsScreenPresenter presenter;
  private ViewDetailsBinding     binding;

  public RepositoryDetailsView(final Context context) {
    this(context, null);
  }

  public RepositoryDetailsView(final Context context, final AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RepositoryDetailsView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    MainActivity.getComponent(context)
        .inject(this);
  }

  @Override
  public void bind(final Repository repository) {
    binding.setRepository(repository);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    binding = ViewDetailsBinding.bind(this);
  }
}
