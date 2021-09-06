package com.android_easing

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class EasingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val graphOutline = GraphOutline()
    private val easeLine = EaseLine()

    private val spacing: Float
        get() = pxToDP(25f)
    
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            graphOutline.draw(
                it,
                0f + spacing,
                0f + spacing,
                width.toFloat() - spacing,
                height.toFloat() - spacing,
                pxToDP(20f)
            )
            easeLine.draw(it)
        }
    }

    fun plot(fraction: Double, time: Double) {
        val w = width - spacing * 2
        val h = height - spacing * 2
        val x = (w * time).toFloat() + spacing
        val t = 1 - fraction
        val y = (h * t).toFloat() + spacing
        easeLine.add(x, y)
        invalidate()
    }
}