package com.example.admin.guang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.example.admin.guang.BR;
import com.example.admin.guang.CommentBean;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseHolder;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.ItemCommentBinding;

import java.util.List;

/**
 * Created by admin on 2017/3/18.
 */

public class CommentRecyclerAdapter extends BaseRecycylerAdapter<CommentBean.DataBean.CommentListBean> {
    public CommentRecyclerAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    protected BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {

        return new CommentHolder(ItemCommentBinding.inflate(inflater));
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        super.onBindViewHolder(holder, position);
       if(holder instanceof CommentHolder){

           CommentHolder h = (CommentHolder) holder;
           CommentBean.DataBean.CommentListBean itemAtPosition = getItemAtPosition(position);
           List<CommentBean.RepileBean> replies = itemAtPosition.getReplies();
           h.update(null);
           h.update(replies);
       }
    }

    @Override
    protected int getChildItemViewType(int position) {
        return 0;
    }

    @ActivityFragmentAnnoation(contentId = BR.listbean)
    class CommentHolder extends BaseHolder<CommentBean.DataBean.CommentListBean> {
        RepileRecyclerAdapter adapter;

        public CommentHolder(ViewDataBinding binding) {
            super(binding);
            binding.setVariable(BR.manager, new LinearLayoutManager(binding.getRoot().getContext()));
            adapter = new RepileRecyclerAdapter(binding.getRoot().getContext());
            binding.setVariable(BR.adapter, adapter);
            RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT);
            binding.getRoot().setLayoutParams(layoutParams);

        }

        public void update(List<CommentBean.RepileBean> list) {
            adapter.updateDataSource(list);
        }


    }
}
