package com.coroutine.bod.optimiza

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.*
import android.provider.Settings

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.coroutine.bod.optimiza.R.id.async

import com.coroutine.bod.optimiza.idle.BusyHandler
import com.coroutine.bod.optimiza.idle.IdleHandler
import com.coroutine.bod.optimiza.utils.RetrofitHelper

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import retrofit2.Retrofit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private val mRetrofitHelper = RetrofitHelper()

    @SuppressLint("HandlerLeak")
    internal var mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            Log.d("IdleHandler", "这里会进行状态的改变哦")
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            super.handleMessage(msg)
        }
    }
    private var imageView: ImageView? = null
    private val build: Retrofit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.iv)

        //traceview 分析工具
        Debug.startMethodTracing("trace")
        SystemClock.sleep(2000)
        Debug.stopMethodTracing()

        findViewById<View>(R.id.tvHelloWorld).setOnClickListener(this)

        tvHelloWorld.text = " 这是一个温馨提示                                          "


        tvHelloWorld.isSelected = true

        val coroutineDispatcher = newSingleThreadContext("ctx")

        GlobalScope.launch(coroutineDispatcher){
            LogUtils.showLog("first coroutine")

        }

        thread(true){
            var deferred = (1..1000).map { n->{

            } }


            for (index in 0..10){
                val get = deferred.get(index)
            }
        }


        var implAdapter = ImplAdapter()
        for (index in 0 until 30){
            implAdapter.addData("$index")
        }

        rlAll.adapter = implAdapter
        rlAll.layoutManager = LinearLayoutManager(this)
//        implAdapter.setLoadMoreView(CustomLoadMoreView())

//        implAdapter.disableLoadMoreIfNotFullPage(rlAll)
        implAdapter.setOnLoadMoreListener({
            rlAll.postDelayed(object:Runnable{
                override fun run() {
                    if (implAdapter.data.size==35) {
                        implAdapter.loadMoreEnd()
                    }else{
                        implAdapter.addData("hhh")
                        implAdapter.loadMoreComplete()
                    }
                }
            },3000)
        },rlAll)



    }

    override fun onResume() {
        super.onResume()
        Looper.myQueue().addIdleHandler(IdleHandler())
        Looper.myQueue().addIdleHandler(BusyHandler())
    }

    override fun onClick(v: View) {
        //模拟点击事件

    }


    companion object {
        const val DATASTRING = "dataString";
    }


    //
    fun alarmManager(){
        var alramIntent = Intent()
        alramIntent.setAction("LOCATION")
        //延时的意图
        var pendingIntent = PendingIntent.getBroadcast(this,111,alramIntent,0)
        var alarmManager = getSystemService(Context.ALARM_SERVICE)
        //发送定位信息，需要AlarmManager，通过广播唤醒，然后发送数据
        //jobscheduler
    }

    fun jobScheduler(){

    }


    fun power(a:Int){
        //用处  工作流合并
        var powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager

        var intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)
        intent.data = (Uri.parse("package:$packageName"))
        "pacakge$a"
        startActivity(intent)
    }
}


