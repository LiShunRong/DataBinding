package com.example.admin.guang.fragment.utils;

import android.content.Context;

import com.example.admin.guang.adapter.RiBaoRecyclerAdapter;
import com.example.admin.guang.base.BaseRecycylerAdapter;

/**
 * Created by admin on 2017/3/14.
 */

public class AdapterManager {
    public static BaseRecycylerAdapter get(Context ctx,String type){
        if("daily".equals(type)){
            return new RiBaoRecyclerAdapter(ctx);
        }
        return null;
    }
}
