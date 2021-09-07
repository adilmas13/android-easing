package com.android_easing.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.android_easing.pxToDP

class EasingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val graphOutline = GraphOutline()
    private val easeLine = EaseLine()
    private val circle = Circle()

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
            circle.x = width.toFloat() - 40
            if (circle.isFirstDraw) {
                circle.y = height.toFloat() - spacing
                circle.isFirstDraw = false
            }
            circle.draw(it)
        }
    }

    fun plot(fraction: Double, time: Double) {
        fun updateEaseLine() {
            val w = width - spacing * 2
            val h = height - spacing * 2
            val x = (w * time).toFloat() + spacing
            val t = 1 - fraction
            val y = (h * t).toFloat() + spacing
            easeLine.add(x, y)
        }

        fun updateCircle() {
            val h = height - spacing * 2
            val t = 1 - fraction
            val y = (h * t).toFloat() + spacing
            circle.y = y
        }

        updateEaseLine()
        updateCircle()
        invalidate()
    }

    fun clear(){
        easeLine.clear()
    }
}