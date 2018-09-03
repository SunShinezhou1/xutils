package com.example.exam_oneday;

import android.app.Application;

import org.xutils.x;

public class app extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(app.this);
    }
}
