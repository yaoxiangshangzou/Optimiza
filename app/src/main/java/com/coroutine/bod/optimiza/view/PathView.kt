package com.coroutine.bod.optimiza.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathView
@JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private var mPaint:Paint? = null

    private var mPath = Path()

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint?.apply {
            color = Color.BLUE
            strokeCap = Paint.Cap.ROUND
        }
    }


    companion object {
        init {
            //静态代码块
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPath.apply{
            lineTo(10f,10f)
            lineTo(100f,100f)
            rLineTo(30f,30f)
        }
        canvas?.drawPath(mPath,mPaint)
    }


}