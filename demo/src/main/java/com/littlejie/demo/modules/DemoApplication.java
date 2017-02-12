package com.littlejie.demo.modules;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import com.littlejie.core.base.BaseApplication;

/**
 * Created by littlejie on 2017/2/6.
 */

public class DemoApplication extends BaseApplication {

    private static NotificationManager mNotificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        //通过静态广播、分享之类的 Intent 调起，都会调用 Application 的 onCreate() 方法
        Log.d(TAG, "onCreate: DemoApplication onCreate");
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static NotificationManager getNotificationManager() {
        return mNotificationManager;
    }
}
