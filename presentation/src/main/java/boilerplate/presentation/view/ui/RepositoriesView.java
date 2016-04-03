package boilerplate.presentation.view.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import boilerplate.BoilerplateApp;
import boilerplate.R;
import boilerplate.databinding.ListItemBinding;
import boilerplate.databinding.ViewRepositoriesBinding;
import boilerplate.presentation.model.Repository;
import boilerplate.presentation.presenter.MainScreenPresenter;
import boilerplate.presentation.view.MainRouter;
import boilerplate.presentation.view.MainScreenView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-15, 20:30
 */
public final class RepositoriesView extends LinearLayout implements MainScreenView {
  @Inject MainScreenPresenter     mPresenter;
  private RepositoriesAdapter     mAdapter;
  private ViewRepositoriesBinding mBinding;

  public RepositoriesView(final Context context) {
    this(context, null);
  }

  public RepositoriesView(final Context context, final AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RepositoriesView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setOrientation(VERTICAL);
    (((BoilerplateApp) context.getApplicationContext()).getComponent()).inject(this);
  }

  @Override protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    mPresenter.takeView(this);
    mPresenter.takeRouter(((MainRouter) ((ContextWrapper) getContext()).getBaseContext()));
  }

  @Override protected void onDetachedFromWindow() {
    mPresenter.dropRouter();
    mPresenter.dropView();
    super.onDetachedFromWindow();
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    mBinding = ViewRepositoriesBinding.bind(this);
    mAdapter = new RepositoriesAdapter(new ArrayList<>());
    mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mBinding.recyclerView.setAdapter(mAdapter);
    mBinding.button.setOnClickListener(this::onGetRepositoriesButtonClick);
  }

  private void onGetRepositoriesButtonClick(View v) {
    mPresenter.getRepositories(mBinding.editText.getText()
        .toString()
        .trim());
  }

  @Override public void setRepositories(final List<Repository> repositories) {
    mAdapter.setItems(repositories);
    mAdapter.notifyDataSetChanged();
  }

  public static class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder> {
    private final List<Repository> mRepositories;

    RepositoriesAdapter(List<Repository> repositories) {
      mRepositories = new ArrayList<>(repositories);
    }

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url) {
      Context context = imageView.getContext();
      Glide.with(context)
          .load(url)
          .placeholder(R.mipmap.ic_launcher)
          .into(imageView);
    }

    @Override public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
      final ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new MyViewHolder(binding);
    }

    @Override public void onBindViewHolder(final MyViewHolder holder, final int position) {
      holder.mBinding.setRepository(mRepositories.get(position));
    }

    @Override public int getItemCount() {
      return mRepositories.size();
    }

    public void setItems(final List<Repository> repositories) {
      mRepositories.clear();
      mRepositories.addAll(repositories);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
      final ListItemBinding mBinding;

      MyViewHolder(final ListItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
      }
    }
  }
}
