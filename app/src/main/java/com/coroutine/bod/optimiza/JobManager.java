package com.coroutine.bod.optimiza;

import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class JobManager {


    static JobManager jobManager;

    JobScheduler jobScheduler;

    //避免频繁的唤醒 硬件模块，
    private JobManager mJsonScheduler(){
        if (jobManager == null){
            jobManager = new JobManager();
        }
        return jobManager;
    }

    //要么使用发射 要么使用进程间的IPC通讯
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init(Context context){
        Context applicationContext = context.getApplicationContext();
        jobScheduler = (JobScheduler) applicationContext.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

}
