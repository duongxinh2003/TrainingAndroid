package com.fu.databindingdemo.view;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.fu.databindingdemo.util.NetworkUtils;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseObservable> extends AppCompatActivity {
    private T binding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        onCreateActivity();
    }

    protected abstract void onCreateActivity();

    private void init() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = setViewModel();
        binding.setVariable(getVariableId(),viewModel);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    protected abstract int getVariableId();

    protected abstract V setViewModel();

    protected abstract int getLayoutId();

    public T getBinding() {
        return binding;
    }

    public V getViewModel() {
        return viewModel;
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
