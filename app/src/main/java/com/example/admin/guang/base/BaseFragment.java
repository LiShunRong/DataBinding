package com.example.admin.guang.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.utils.ActivityFragmentAnnoationManager;

/**
 * Created by admin on 2017/3/14.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected Bundle bundle;
    private int contentId;
    protected T binding;
    protected Activity a;


    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (contentId == 0) {
            bundle = getArguments();
            contentId = ActivityFragmentAnnoationManager.check(this);
            a = context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, contentId, container, false);
            initFragmentImpl();
        }
        return binding.getRoot();
    }


    protected abstract void initFragmentImpl();
}
