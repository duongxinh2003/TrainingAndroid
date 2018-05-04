package com.fu.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.fu.databindingdemo.BR;

public class ContactViewModel extends BaseObservable {
    private String phone;
    private String name;

    public ContactViewModel() {
    }

    public ContactViewModel(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getFirstChar() {
        return name.substring(0,1);
    }
}
