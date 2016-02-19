package com.qianfeng.liu.itrip.others;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 *
 * Created by Liu Shouxiang
 *
 * @Date on 2016/1/28.
 */
public class MyApplication extends Application{
    public static RequestQueue mQueue ;

    @Override
    public void onCreate() {
        super.onCreate();
        mQueue = Volley.newRequestQueue(this);
    }
}
