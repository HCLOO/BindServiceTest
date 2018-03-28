package com.example.think.bindservicetest;

import android.os.AsyncTask;
import android.util.Log;

import static com.example.think.bindservicetest.MainActivity.progressBar;

/**
 * Created by Think on 2018/3/28.
 */

public class ProgressTask extends AsyncTask<Void,Integer,Boolean> {

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        for(int i=0;i<=100;++i)
            publishProgress(i);
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean==true)
            Log.d("提示：", "下载完成！");
    }
}
