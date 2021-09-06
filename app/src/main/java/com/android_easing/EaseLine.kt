package com.android_easing

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

class EaseLine {
    private val paint = Paint()
    private val path = Path()

    init {
        paint.apply {
            color = Color.rgb(174, 174, 174)
            strokeWidth = 12.toFloat()
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
        }
    }

    fun draw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }

    fun add(x: Float, y: Float) {
        if (path.isEmpty) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }
}