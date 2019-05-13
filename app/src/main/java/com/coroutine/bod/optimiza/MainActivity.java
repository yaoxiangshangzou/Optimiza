package com.coroutine.bod.optimiza;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coroutine.bod.optimiza.idle.BusyHandler;
import com.coroutine.bod.optimiza.idle.IdleHandler;
import com.coroutine.bod.optimiza.utils.RetrofitHelper;
import com.coroutine.bod.optimiza.view.PathView;

import java.io.IOException;
import java.security.PublicKey;

import kotlin.jvm.functions.Function2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RetrofitHelper mRetrofitHelper = new RetrofitHelper();

    private static Context sContext;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.d("IdleHandler","这里会进行状态的改变哦");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.handleMessage(msg);
        }
    };
    private ImageView imageView;
    private Retrofit build;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv);

        //traceview 分析工具
        Debug.startMethodTracing("trace");
        SystemClock.sleep(2000);
        Debug.stopMethodTracing();

        findViewById(R.id.tvHelloWorld).setOnClickListener(this);

        sContext = this;



    }

    @Override
    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new IdleHandler());
        Looper.myQueue().addIdleHandler(new BusyHandler());
    }

    @Override
    public void onClick(View v) {
        //模拟点击事件

        final Call<BookBean> book = mRetrofitHelper.getBook();

        book.enqueue(new Callback<BookBean>() {
            @Override
            public void onResponse(Call<BookBean> call, Response<BookBean> response) {
                Call<BookBean> clone = call.clone();
            }

            @Override
            public void onFailure(Call<BookBean> call, Throwable t) {

            }
        });
    }


    public void loadBitmap(){


    }



}
