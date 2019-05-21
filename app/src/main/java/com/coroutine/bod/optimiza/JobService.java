package com.coroutine.bod.optimiza;

import android.annotation.SuppressLint;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

@SuppressLint("NewApi")
public class JobService extends android.app.job.JobService {


    //返回false 执行onStopJob
    //true执行jobFinished 通知系统
    //params 通过jobscheduler执行的时候，所有的信息都在这里
    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    //返回false
    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    class MyAsyncTask extends AsyncTask<JobParameters,Void,Void>{

        @Override
        protected Void doInBackground(JobParameters... jobParameters) {
            return null;
        }
    }
}
