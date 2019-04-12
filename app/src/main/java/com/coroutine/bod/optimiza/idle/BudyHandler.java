package com.coroutine.bod.optimiza.idle;

import android.os.MessageQueue;
import android.util.Log;

public class BudyHandler implements MessageQueue.IdleHandler {
    //比如ViewPager的懒加载，但是当我们的主页渲染ok,此时的Handler是处于空闲的状态，如果我们能够获取到回调，
    //就能在主线程结束忙碌的绘制之后，拿到那个空闲的时间点
    @Override
    public boolean queueIdle() {
        Log.d("IdleHandler","这里进行延时的数据加载");
        //返回false只会执行一次，true执行很多的
        return false;
    }
}
