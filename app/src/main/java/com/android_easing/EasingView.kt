package com.android_easing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View

class EasingView(context: Context,  attrs: AttributeSet) : View(context, attrs) {
    private val borderPaint = Paint()
    private val linePaint = Paint()
    private val linePath = Path()

    init {
        borderPaint.apply {
            color = Color.rgb(77, 83, 96)
            isAntiAlias = true
            strokeWidth = 3.0.toFloat()
            style = Paint.Style.STROKE
        }

        linePaint.apply {
            color = Color.rgb(77, 83, 96)
            strokeWidth = 3.0.toFloat()
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            drawBorder(it)
            drawEase(it)
        }
    }

    private fun drawBorder(canvas: Canvas){
        val left = 0f
        val top = 0f
        val right = width.toFloat()
        val bottom = height.toFloat()
        canvas.drawRect(left,top, right, bottom, borderPaint)
    }

    private fun drawEase(canvas:Canvas){
        canvas.drawPath(linePath, linePaint)
    }

    fun plot(point: Double){
        val x = (width * point).toFloat()
        val y = (height * (1-point)).toFloat()
        if (linePath.isEmpty){
            linePath.moveTo(x, y)
        }else{
            linePath.lineTo(x, y)
        }
        invalidate()
    }

    fun clear(){
        linePath.reset()
        invalidate()
    }
}