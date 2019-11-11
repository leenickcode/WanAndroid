package com.nick.wanandroid.app;

import android.app.Application;

/**
 * @author nick
 * @date 2019/11/11 0011
 * @Description
 */
public class MyApplication extends Application {
   static  MyApplication instance;
 public   static MyApplication getInstance(){
       return instance;
   }
    @Override
    public void onCreate() {
        super.onCreate();
        instance= this;
    }
 }
