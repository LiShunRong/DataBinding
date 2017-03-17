package com.example.admin.guang.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.example.admin.guang.utils.ActivityFragmentAnnoationManager;

import java.util.Map;

/**
 * Created by admin on 2017/3/14.
 */

public class BaseHolder<T> extends RecyclerView.ViewHolder {
    ViewDataBinding binding;
    protected int dataId;

    public BaseHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        dataId = ActivityFragmentAnnoationManager.check(this);
    }
    public void bind(T t) {
        if(binding==null)
            throw new UnsupportedOperationException("不支持binding");
        binding.setVariable(dataId, t);
        binding.executePendingBindings();
    }
    public BaseHolder(View itemView){
        super(itemView);
    }
}
