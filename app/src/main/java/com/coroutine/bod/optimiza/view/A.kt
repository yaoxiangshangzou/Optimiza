package com.coroutine.bod.optimiza.view

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class A : View {

    private var paint: Paint? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
    }
}
