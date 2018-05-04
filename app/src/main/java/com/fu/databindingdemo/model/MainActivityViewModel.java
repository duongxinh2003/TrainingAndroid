package com.fu.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.fu.databindingdemo.BR;
import com.fu.databindingdemo.recyclerview.SingleTypeAdapter;

public class MainActivityViewModel extends BaseObservable{
    private String text;
    public SingleTypeAdapter<ContactViewModel> adapter;

    public MainActivityViewModel() {
    }

    public MainActivityViewModel(String text) {
        this.text = text;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    public SingleTypeAdapter<ContactViewModel> getAdapter() {
        return adapter;
    }

    public void setAdapter(SingleTypeAdapter<ContactViewModel> adapter) {
        this.adapter = adapter;
    }
}
