package com.coroutine.bod.optimiza.idle;

import android.os.MessageQueue;
import android.util.Log;

public class IdleHandler implements MessageQueue.IdleHandler {
    @Override
    public boolean queueIdle() {
        Log.d("IdleHandler","我很空 求约啊");
        return false;
    }
}
