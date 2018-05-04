package com.fu.databindingdemo.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SingleTypeAdapter<T> extends BaseRecyclerViewAdapter<T> {
    protected int layoutResource;


    public SingleTypeAdapter(Context context) {
        this(context, 0);
    }

    public SingleTypeAdapter(Context context, int layoutRes) {
        super(context);
        collection = new ArrayList<>();
        layoutResource = layoutRes;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BindingViewHolder(DataBindingUtil.inflate(layoutInflater, getLayoutRes(), parent, false));
    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    public void add(T viewModel) {
        collection.add(viewModel);
        notifyDataSetChanged();
    }

    public void add(int position, T viewModel) {
        collection.add(position, viewModel);
        notifyDataSetChanged();
    }

    public void set(List<T> viewModels) {
        collection.clear();
        addAll(viewModels);
    }

    public void addAll(List<T> viewModels) {
        collection.addAll(viewModels);
        notifyDataSetChanged();
    }

    public int getLayoutRes() {
        return layoutResource;
    }

    public interface Presenter<T> extends BaseRecyclerViewAdapter.Presenter {
        void onItemClick(T t);
    }
}
