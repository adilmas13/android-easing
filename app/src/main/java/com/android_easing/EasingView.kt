package com.android_easing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class EasingView(context: Context,  attrs: AttributeSet) : View(context, attrs) {
    private val borderPaint = Paint()
    private val linePaint = Paint()
    private val linePath = Path()

    private var rectX = 0.0f

    companion object{
        const val WIDTH = 100f
        const val HEIGHT = 100f
        const val TOP = 50f
    }

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
            drawRect(it)
//            drawBorder(it)
//            drawEase(it)
        }
    }

    private fun drawRect(canvas: Canvas){
        canvas.drawRect(rectX, TOP, rectX+ WIDTH, TOP+ HEIGHT, Paint().apply {
            color = Color.BLUE
            style=Paint.Style.FILL
        })
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

    fun plot2(point: Float){
        rectX = (width - WIDTH) * point
        invalidate()
    }



    fun clear(){
        linePath.reset()
        invalidate()
    }
}