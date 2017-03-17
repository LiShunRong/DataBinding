package com.example.admin.guang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.example.admin.guang.BR;
import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseHolder;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.ItemDuanziBinding;
import com.example.admin.guang.databinding.ItemTupianBinding;
import com.example.admin.guang.fragment.utils.GiftUtils;
import com.example.admin.guang.utils.UpDown;

/**
 * Created by admin on 2017/3/15.
 */

public class DuanZiRecycylerAdapter extends BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> {
    public DuanZiRecycylerAdapter(Context ctx) {
        super(ctx);
    }
    @Override
    protected BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        ItemDuanziBinding inflate = ItemDuanziBinding.inflate(inflater, parent, false);
        return new DuanZiHolder(inflate);
    }
    @Override
    protected int getChildItemViewType(int position) {
        return 0;
    }
    @ActivityFragmentAnnoation(contentId = BR.bean)
    class DuanZiHolder extends BaseHolder<CommunityBean.DataBean.ListBean>{

        public DuanZiHolder(ViewDataBinding binding) {
            super(binding);
            binding.setVariable(BR.updown,new UpDown());
        }
    }

}
