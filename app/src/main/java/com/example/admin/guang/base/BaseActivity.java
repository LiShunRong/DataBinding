package com.example.admin.guang.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.utils.ActivityFragmentAnnoationManager;

/**
 * Created by admin on 2017/3/14.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initActivityImpl();

    }

    protected abstract void initActivityImpl();

    private void initView() {
        int contentId = ActivityFragmentAnnoationManager.check(this);
        binding = DataBindingUtil.setContentView(this, contentId);
    }

}
