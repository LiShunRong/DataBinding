package com.example.admin.guang.utils;

import com.example.admin.guang.annoation.ActivityFragmentAnnoation;

import java.lang.annotation.Annotation;

/**
 * Created by admin on 2017/3/14.
 */

public class ActivityFragmentAnnoationManager {

    public static int check(Object clazz) {
        boolean annotationPresent = clazz.getClass().isAnnotationPresent(ActivityFragmentAnnoation.class);
        if (!annotationPresent) {
            throw new IllegalStateException("Activity必须有注解");
        }
        ActivityFragmentAnnoation annotation = (ActivityFragmentAnnoation) clazz.getClass().getAnnotation(ActivityFragmentAnnoation.class);
        return annotation.contentId();
    }
}
