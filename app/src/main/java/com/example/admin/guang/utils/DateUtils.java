package com.example.admin.guang.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by admin on 2017/3/17.
 */

public class DateUtils {
    public static String getData(long time){
        Log.e("time",time+"");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return format.format(new Date(time));
    }
}
