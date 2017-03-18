package com.example.admin.guang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.guang.CommentBean;
import com.example.admin.guang.R;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseHolder;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.ItemRepileBinding;

/**
 * Created by admin on 2017/3/19.
 */

public class RepileRecyclerAdapter extends BaseRecycylerAdapter<CommentBean.RepileBean> {
    public RepileRecyclerAdapter(Context ctx) {
        super(ctx);
        removeFooterView();

    }

    @Override
    protected BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return new RepileHolder(ItemRepileBinding.inflate(inflater));
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
//        super.onBindViewHolder(holder, position);
        CommentBean.RepileBean itemAtPosition = getItemAtPosition(position);
        RepileHolder h= (RepileHolder) holder;
        ((TextView)(h.itemView.findViewById(R.id.other))).setText(itemAtPosition.getOther_name());
        ((TextView)(h.itemView.findViewById(R.id.content))).setText(itemAtPosition.getContent());
    }

    @Override
    protected int getChildItemViewType(int position) {
        return 0;
    }
    @ActivityFragmentAnnoation(contentId = R.layout.item_repile)
    class RepileHolder extends BaseHolder<CommentBean.RepileBean>{

        public RepileHolder(ViewDataBinding binding) {
            super(binding);
            RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT);
            binding.getRoot().setLayoutParams(layoutParams);
        }
    }
}
