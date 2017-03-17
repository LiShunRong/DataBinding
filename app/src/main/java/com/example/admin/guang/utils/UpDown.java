package com.example.admin.guang.utils;

import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.UpDownBean;
import com.example.admin.guang.service.OnLoadDataFinishListener;

/**
 * Created by admin on 2017/3/17.
 */

public class UpDown implements OnLoadDataFinishListener<UpDownBean> {
    CommunityBean.DataBean.ListBean bean;
    CheckBox cb;
    public void updateState(CheckBox cb, CommunityBean.DataBean.ListBean listBean){
        bean=listBean;
        cb.setChecked(listBean.getIs_praise()==1);
        int is_praise = listBean.getIs_praise();
        Log.e("tag",is_praise+"");
      if(is_praise==1)return;
        // 这个type  和服务器具体什么关系  位置
        HttpUtils.updown(listBean.getId()+"",2,1,this);
    }

    @Override
    public void loadSuccess(UpDownBean upDownBean, int page) {
        Log.e("tag",upDownBean+"");
        bean.setIs_praise(1);
        cb.setChecked(1==1);
    }

    @Override
    public void loadError(String msg, int page) {
        Log.e("tag",msg+"------->");
    }
}
