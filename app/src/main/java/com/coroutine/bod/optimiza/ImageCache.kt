package com.coroutine.bod.optimiza

import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache
import java.lang.ref.ReferenceQueue

object ImageCache {


    //x+y是形式参数
    @JvmStatic
    var sum:(x:Int,y:Int)->Int={
        x, y -> x+y
    }

    var reference = ReferenceQueue<Bitmap>()

    fun init(context: Context) {
        var lruCache = LruCache<String, Bitmap>(100)
    }

    //weakreferencequeue 扫描到引用为空的时候
    //就将其交到navive层区处理

    fun foreach(){
        val list = listOf("1", "2", "3")
        val list1 = list ?: listOf("1")
        list.forEachIndexed {
            index, s -> print("$s $index")
        }

        list.forEach {
            val it1 = it
        }

    }


}