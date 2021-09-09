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

    private val leftSpacing: Float
        get() = pxToDP(25f)

    private val rightSpacing: Float
        get() = pxToDP(25f)

    private val topSpacing: Float
        get() = pxToDP(90f)

    private val bottomSpacing: Float
        get() = pxToDP(90f)

    private val horizontalSpacing: Float
        get() = leftSpacing + rightSpacing

    private val verticalSpacing: Float
        get() = topSpacing + bottomSpacing

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            graphOutline.draw(
                it,
                0f + leftSpacing,
                0f + topSpacing,
                width.toFloat() - rightSpacing,
                height.toFloat() - bottomSpacing,
                pxToDP(20f)
            )
            easeLine.draw(it)
            circle.x = width.toFloat() - 30
            if (circle.isFirstDraw) {
                circle.y = height.toFloat() - bottomSpacing
                circle.isFirstDraw = false
            }
            circle.draw(it)
        }
    }

    fun plot(fraction: Double, time: Double) {
        fun updateEaseLine() {
            val w = width - horizontalSpacing
            val h = height - verticalSpacing
            val x = (w * time).toFloat() + leftSpacing
            val t = 1 - fraction
            val y = (h * t).toFloat() + bottomSpacing
            easeLine.add(x, y)
        }

        fun updateCircle() {
            val h = height - verticalSpacing
            val t = 1 - fraction
            val y = (h * t).toFloat() + bottomSpacing
            circle.y = y
        }

        updateEaseLine()
        updateCircle()
        invalidate()
    }

    fun clear() {
        easeLine.clear()
    }
}