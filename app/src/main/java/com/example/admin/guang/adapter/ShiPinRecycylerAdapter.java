package com.example.admin.guang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.example.admin.guang.BR;
import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseHolder;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.ItemShipinBinding;

/**
 * Created by admin on 2017/3/15.
 */

public class ShiPinRecycylerAdapter extends BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> {
    public ShiPinRecycylerAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    protected BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        ItemShipinBinding inflate = ItemShipinBinding.inflate(inflater, parent, false);
        return new ShiPinHolder(inflate);
    }

    @Override
    protected int getChildItemViewType(int position) {
        return 0;
    }
    @ActivityFragmentAnnoation(contentId = BR.bean)
    class ShiPinHolder extends BaseHolder<CommunityBean.DataBean.ListBean>{

        public ShiPinHolder(ViewDataBinding binding) {
            super(binding);
        }
    }

}
