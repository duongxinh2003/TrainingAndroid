package com.fu.databindingdemo.model;

import com.fu.databindingdemo.model.ContactViewModel;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    public static final List<ContactViewModel> LIST_DUMMY = new ArrayList<ContactViewModel>(){{
        add(new ContactViewModel("0123456789","ABC"));
        add(new ContactViewModel("1234049884","DEF"));
        add(new ContactViewModel("8329018901","GHI"));
    }};
}