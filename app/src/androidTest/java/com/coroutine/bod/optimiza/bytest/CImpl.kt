package com.coroutine.bod.optimiza.bytest

import android.util.Log
import com.coroutine.bod.optimiza.LogUtils

class CImpl:IBase {

    override fun test() {
        super.test()
        LogUtils.showLog("老子是C,实现了委托的功能")
    }
}