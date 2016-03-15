package boilerplate.presentation.view.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import boilerplate.R;
import boilerplate.databinding.ListItemBinding;
import boilerplate.presentation.model.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Mar-15, 20:30
 */
public final class RepositoriesView extends FrameLayout {
  private final RecyclerView        mRecyclerView;
  private       RepositoriesAdapter mAdapter;

  public RepositoriesView(final Context context) {
    this(context, null);
  }

  public RepositoriesView(final Context context, final AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RepositoriesView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    View.inflate(context, R.layout.content_main, this);
    mRecyclerView = (RecyclerView) findViewById(R.id.repositories_list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    mAdapter = new RepositoriesAdapter(new ArrayList<>());
    mRecyclerView.setAdapter(mAdapter);
  }

  public void setItems(List<Repository> repositories) {
    mAdapter.setItems(repositories);
    mAdapter.notifyDataSetChanged();
  }

  static class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder> {
    private final List<Repository> mRepositories;

    RepositoriesAdapter(List<Repository> repositories) {
      mRepositories = new ArrayList<>(repositories);
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
