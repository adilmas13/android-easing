package com.android_easing.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Circle {

    private val paint = Paint()
    var isFirstDraw = true

    var x = 0f
    var y: Float? = 0f

    init {
        paint.apply {
            color = Color.rgb(0, 154, 255)
            style = Paint.Style.FILL
        }
    }

    fun draw(canvas: Canvas) {
        y?.let { canvas.drawCircle(x, it, 20f, paint) }
    }
}