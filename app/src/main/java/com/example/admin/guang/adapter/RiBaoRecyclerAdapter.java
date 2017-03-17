package com.example.admin.guang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.example.admin.guang.BR;
import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseHolder;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.ItemRibaoBinding;

/**
 * Created by admin on 2017/3/14.
 */

public class RiBaoRecyclerAdapter extends BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> {
    public RiBaoRecyclerAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    protected BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return new RiBaoHolder(ItemRibaoBinding.inflate(inflater, parent, false));
    }

    @Override
    protected int getChildItemViewType(int position) {
        return 0;
    }


    @ActivityFragmentAnnoation(contentId = BR.bean)
    private class RiBaoHolder extends BaseHolder<CommunityBean.DataBean.ListBean> {
        public RiBaoHolder(ViewDataBinding binding) {
            super(binding);
        }
    }
}
