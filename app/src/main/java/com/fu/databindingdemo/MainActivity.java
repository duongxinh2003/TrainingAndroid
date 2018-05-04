package com.fu.databindingdemo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.fu.databindingdemo.databinding.ActivityMainBinding;
import com.fu.databindingdemo.model.Constant;
import com.fu.databindingdemo.model.ContactViewModel;
import com.fu.databindingdemo.model.MainActivityViewModel;
import com.fu.databindingdemo.recyclerview.BaseRecyclerViewAdapter;
import com.fu.databindingdemo.recyclerview.SingleTypeAdapter;
import com.fu.databindingdemo.view.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> {
    private final List<ContactViewModel> mList = Constant.LIST_DUMMY;

    @Override
    protected void onCreateActivity() {
        SingleTypeAdapter<ContactViewModel> adapter = new SingleTypeAdapter<>(this, R.layout.item_recyclerview);
        //add View Moodel
        adapter.addAll(mList);
        //add Listener
        adapter.setPresenter(new OnClickItem());
        getBinding().setLayoutManager(new LinearLayoutManager(this));
        getBinding().setAdapter(adapter);
        hideKeyboard();
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected MainActivityViewModel setViewModel() {
        MainActivityViewModel model = new MainActivityViewModel("Before");
        model.setText("Contact");
        return model;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public class OnClickItem implements BaseRecyclerViewAdapter.Presenter {

        public void onItemClick(String values) {
            Toast.makeText(getApplicationContext(), values, Toast.LENGTH_SHORT).show();
        }

        public void onLoginActivity() {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}