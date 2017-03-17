package com.example.admin.guang.service;

/**
 * Created by admin on 2017/3/14.
 */

public interface OnLoadDataFinishListener<T> {

    void loadSuccess(T t,int page);

    void loadError(String msg,int page);
}
