package com.coroutine.bod.optimiza

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_inner.*
import kotlinx.coroutines.*

//ctrl + Y 弹出提示框
class CoroutineActivity : AppCompatActivity() {

    var mJob: Job? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inner)

        //非阻塞的
        mJob = GlobalScope.launch(Dispatchers.Main) {
            LogUtils.showLog(fetchData())
        }

        LogUtils.showLog("22222")

       //阻塞
        runBlocking {
            delay(1000)
            LogUtils.showLog("runBlocking:111")
        }

        LogUtils.showLog("runBlocking222")

        //线程切换
        GlobalScope.launch(Dispatchers.IO){

            val result = "Result of GlobalScope"

            withContext(Dispatchers.Main){
                tv_inner.text = "Data from Main Thread$result"
            }
        }

    }

    //挂起函数
    private suspend fun fetchData(): String {
        delay(6000)
        LogUtils.showLog("11111")
        return "FetchedData"
    }

    override fun onDestroy() {
        super.onDestroy()
        mJob?.cancel()
    }

}
