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
import com.example.admin.guang.databinding.ItemTupianBinding;
import com.example.admin.guang.fragment.utils.GiftUtils;

/**
 * Created by admin on 2017/3/15.
 */

public class TuPianRecycylerAdapter extends BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> {
    public TuPianRecycylerAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    protected BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        ItemTupianBinding inflate = ItemTupianBinding.inflate(inflater, parent, false);
        return new TuPianHolder(inflate);
    }
    @Override
    protected int getChildItemViewType(int position) {
        return 0;
    }
    @ActivityFragmentAnnoation(contentId = BR.bean)
    class TuPianHolder extends BaseHolder<CommunityBean.DataBean.ListBean>{

        public TuPianHolder(ViewDataBinding binding) {
            super(binding);
            binding.setVariable(BR.giftUtils,new GiftUtils());
        }
    }

}
