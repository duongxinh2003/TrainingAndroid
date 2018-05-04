package com.fu.databindingdemo.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected final T bindingData;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        bindingData = binding;
    }

    public T getBinding() {
        return bindingData;
    }
}
