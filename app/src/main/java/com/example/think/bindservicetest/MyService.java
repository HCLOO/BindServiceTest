package com.example.think.bindservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.ProgressBar;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("提示：", "已绑定服务！");
        MyBinder mbinder=new MyBinder();
        return mbinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("提示：", "已解绑服务！");
    }

    class MyBinder extends Binder {
        public void onFinishTask() {
            ProgressTask task=new ProgressTask();
            task.execute();
        }
    }
}
