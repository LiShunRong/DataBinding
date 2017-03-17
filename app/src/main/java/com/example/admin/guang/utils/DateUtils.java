package com.example.admin.guang.utils;

import java.util.Date;

/**
 * Created by admin on 2017/3/17.
 */

public class DateUtils {
    public static String getData(long time){
        return new Date(time).toLocaleString();
    }
}
