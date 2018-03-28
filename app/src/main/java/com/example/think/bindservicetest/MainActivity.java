package com.example.think.bindservicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ProgressBar progressBar;
    Button start;
    Button stop;
    MyService.MyBinder binder;
    MyServiceConnection conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        progressBar.setMax(100);
        start=(Button)findViewById(R.id.start_button);
        stop=(Button)findViewById(R.id.stop_button);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        conn=new MyServiceConnection();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                Intent startIntent=new Intent(MainActivity.this,MyService.class);
                bindService(startIntent,conn,BIND_AUTO_CREATE);
                break;
            case R.id.stop_button:
                unbindService(conn);
                break;
                default:break;
        }
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder=(MyService.MyBinder)iBinder;
            binder.onFinishTask();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
