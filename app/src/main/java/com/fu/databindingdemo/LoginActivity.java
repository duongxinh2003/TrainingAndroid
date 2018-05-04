package com.fu.databindingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fu.databindingdemo.databinding.ActivityLoginBinding;
import com.fu.databindingdemo.model.ContactViewModel;
import com.fu.databindingdemo.view.BaseActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, ContactViewModel> {

    @Override
    protected void onCreateActivity() {
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected ContactViewModel setViewModel() {
        return new ContactViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}
