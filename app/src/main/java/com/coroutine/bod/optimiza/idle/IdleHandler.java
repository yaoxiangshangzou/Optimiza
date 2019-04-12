package com.coroutine.bod.optimiza.idle;

import android.os.MessageQueue;
import android.util.Log;

public class IdleHandler implements MessageQueue.IdleHandler {
    @Override
    public boolean queueIdle() {
        Log.d("IdleHandler","我很空 求约啊");
        //true会执行很多次
        //比如一些数据的一次性初始化  比如懒加载ViewPager的优化
        return true;
    }
}
