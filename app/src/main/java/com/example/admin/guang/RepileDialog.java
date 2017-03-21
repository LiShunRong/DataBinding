package com.example.admin.guang;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.admin.guang.databinding.LayoutRepileBinding;
import com.example.admin.guang.service.OnLoadDataFinishListener;
import com.example.admin.guang.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/20.
 */

public class RepileDialog extends Dialog implements View.OnClickListener, OnLoadDataFinishListener<RepileBean> {
    LayoutRepileBinding inflate;
    CommentBean.DataBean.CommentListBean bean;
     OnRepileFinishedListener listener;

    public RepileDialog(@NonNull Context context, CommentBean.DataBean.CommentListBean bean ){
        super(context);
        this.bean = bean;
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(android.R.style.Animation_Dialog);
        inflate = LayoutRepileBinding.inflate(LayoutInflater.from(context));
        inflate.setBean(bean);
        inflate.send.setOnClickListener(this);
        setContentView(inflate.getRoot());
        window.setLayout(context.getResources().getDisplayMetrics().widthPixels, WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
    }

    @Override
    public void onClick(View v) {
        String s = inflate.edt.getText().toString();
        if (s.trim().length() < 10) {
            Toast.makeText(getContext(), "长度不能小于10", Toast.LENGTH_SHORT).show();
            return;
        }
        dismiss();
        HttpUtils.loadRepiles(bean.getId(), s, this);
    }

    @Override
    public void loadSuccess(RepileBean repileBean, int page) {
        bean.setReply_number(bean.getReply_number() + 1);
        List<CommentBean.RepileBean> replies = bean.getReplies();
        if (replies == null) {
            replies = new ArrayList<>();
        }
        CommentBean.RepileBean real = new CommentBean.RepileBean();
        real.setContent(repileBean.getData().getReply_content());
        real.setOther_name(repileBean.getData().getNickname());
        replies.add(real);
        bean.setReplies(replies);
        Log.e("tag",bean.getReplies().size()+"");
        if(listener!=null){
            listener.success();
        }
    }

    @Override
    public void loadError(String msg, int page) {
            if(listener!=null){
                listener.failed(msg);
            }
    }
    public interface OnRepileFinishedListener{
        void success();
        void failed(String msg);
    }
    public void setOnRepileFinishedListener(OnRepileFinishedListener listener){
        this.listener=listener;
    }
}
