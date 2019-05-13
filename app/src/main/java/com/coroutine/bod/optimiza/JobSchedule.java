package com.coroutine.bod.optimiza;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;

@SuppressLint("NewApi")
public class JobSchedule extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        //true在子线程中执行 耗时操作往往 需要在子线程中完成
        jobFinished(params,false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        jobFinished(params,false);
        return false;
    }
}
