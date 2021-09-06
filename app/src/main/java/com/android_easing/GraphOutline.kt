package com.android_easing

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

class GraphOutline {
    private val paint = Paint()
    private val path = Path()
    private val textPaint = Paint()

    init {
        paint.apply {
            color = Color.rgb(77, 83, 96)
            strokeWidth = 5.toFloat()
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
        }
        textPaint.apply {
            color = Color.rgb(77, 83, 96)
            style = Paint.Style.FILL
        }
    }

    fun draw(
        canvas: Canvas,
        left: Float,
        top: Float,
        right: Float,
        bottom: Float,
        fontSize: Float
    ) {
        path.moveTo(left, top)
        path.lineTo(left, bottom)
        path.lineTo(right, bottom)
        canvas.drawPath(path, paint)

        canvas.drawText("x", left + 20, top + 30, textPaint.apply {
            textSize = fontSize
        })
        canvas.drawText("t", right - 20, bottom - 30, textPaint.apply {
            textSize = fontSize
        })
    }
}