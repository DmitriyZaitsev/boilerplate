package boilerplate.presentation;

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
import boilerplate.R;
import boilerplate.databinding.ListItemBinding;
import boilerplate.databinding.ViewRepositoriesBinding;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-15, 20:30
 */
public final class RepositoriesView extends LinearLayout implements MainScreenView {
  @Inject MainScreenPresenter     presenter;
  private RepositoriesAdapter     adapter;
  private ViewRepositoriesBinding binding;

  public RepositoriesView(final Context context) {
    this(context, null);
  }

  public RepositoriesView(final Context context, final AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RepositoriesView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setOrientation(VERTICAL);
    MainActivity.getComponent(context)
        .inject(this);
  }

  private static MainRouter routerFrom(Context context) {
    return (MainRouter) ((ContextWrapper) context).getBaseContext();
  }

  @Override
  public void setRepositories(final Collection<Repository> repositories) {
    adapter.setItems(repositories);
    adapter.notifyDataSetChanged();
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    presenter.takeView(this);
    presenter.takeRouter(routerFrom(getContext()));
  }

  @Override
  protected void onDetachedFromWindow() {
    presenter.dropRouter(routerFrom(getContext()));
    presenter.dropView(this);
    super.onDetachedFromWindow();
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    binding = ViewRepositoriesBinding.bind(this);
    adapter = new RepositoriesAdapter(new ArrayList<>(), presenter);
    binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    binding.recyclerView.setAdapter(adapter);
    binding.button.setOnClickListener(this::onGetRepositoriesButtonClick);
  }

  private void onGetRepositoriesButtonClick(View v) {
    presenter.loadRepositories(binding.editText.getText()
        .toString()
        .trim());
  }

  public static final class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder> {
    private final List<Repository>    repositories;
    private final MainScreenPresenter presenter;

    RepositoriesAdapter(List<Repository> repositories, MainScreenPresenter presenter) {
      this.repositories = new ArrayList<>(repositories);
      this.presenter = presenter;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
      final Context context = imageView.getContext();
      Glide.with(context)
          .load(url)
          .placeholder(R.mipmap.ic_launcher)
          .into(imageView);
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
      final ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new MyViewHolder(binding, presenter);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
      holder.binding.setRepository(repositories.get(position));
    }

    @Override
    public int getItemCount() {
      return repositories.size();
    }

    void setItems(final Collection<Repository> repositories) {
      this.repositories.clear();
      if (repositories != null) {
        this.repositories.addAll(repositories);
      }
    }

    static final class MyViewHolder extends RecyclerView.ViewHolder {
      final ListItemBinding binding;

      MyViewHolder(ListItemBinding binding, final MainScreenPresenter presenter) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.container.setOnClickListener(v -> presenter.onItemClicked(this.binding.getRepository()));
      }
    }
  }
}
