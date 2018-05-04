package com.fu.databindingdemo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.fu.databindingdemo.BR;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {
    protected final LayoutInflater layoutInflater;
    protected List<T> collection;
    protected Presenter presenter;
    protected Decorator decorator;


    public BaseRecyclerViewAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        final Object item = collection.get(position);
        holder.getBinding().setVariable(BR.viewModel, item);
        holder.getBinding().setVariable(BR.presenter, getPresenter());
        holder.getBinding().executePendingBindings();
        if(decorator != null) {
            decorator.decorator(holder, position, getItemViewType(position));
        }
    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    public void remove(int pos) {
        collection.remove(pos);
        notifyItemRemoved(pos);
    }

    public void clear() {
        collection.clear();
        notifyDataSetChanged();
    }

    public void setDecorator(Decorator dec) {
        decorator = dec;
    }

    public void setPresenter(Presenter pre) {
        presenter = pre;
    }

    public interface Presenter {
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public interface Decorator {
        void decorator(BindingViewHolder bindingViewHolder,int position, int viewType);
    }
}
