package com.crxjr.app.application;

import android.app.Application;
import android.content.Context;

import com.crxjr.app.http.OkHttpManager;

/**
 * 作者：Arjun
 * 时间：2016/3/28 22:30
 * 邮箱：qianjun942030@163.com
 * 全局Appplication
 */
public class MyApplication extends Application{
    /**
     * 全局Context
     */
    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        OkHttpManager.getInstance().debug("TAG",true);
    }

    /**
     * 返回全局变量Context
     * @return
     */
    public static Context getmContext(){
        return mContext;
    }
}
