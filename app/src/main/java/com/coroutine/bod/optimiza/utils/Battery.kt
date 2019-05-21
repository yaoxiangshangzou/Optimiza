package com.coroutine.bod.optimiza.utils

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.support.annotation.RequiresApi

object Battery {


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun isPlugged(context: Context): Boolean {
        //粘性 有序 无序广播

        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val intent = context.registerReceiver(null, intentFilter)

        val isPlugged = intent!!.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)

        //如果是属于这三种状态的
        return isPlugged == BatteryManager.BATTERY_PLUGGED_USB || isPlugged == BatteryManager.BATTERY_PLUGGED_AC || isPlugged == BatteryManager.BATTERY_PLUGGED_WIRELESS

    }




}
