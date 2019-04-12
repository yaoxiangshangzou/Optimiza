package com.coroutine.bod.optimiza;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.coroutine.bod.optimiza.idle.BusyHandler;
import com.coroutine.bod.optimiza.idle.IdleHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tvHelloWorld).setOnClickListener(this);

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
        for (int i =0;i<3;i++){
            mHandler.sendEmptyMessage(0);
        }
    }
}
