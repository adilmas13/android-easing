package com.android_easing

import com.android_easing.easing.Ease
import com.android_easing.easing.Linear

class EasingManager(private var ease: Ease = Linear(), private var duration: Float) {
    private val ticker = Ticker()

    private var onStart: (() -> Unit)? = null
    private var onEnd: (() -> Unit)? = null
    private var onProgress: ((progress: Double) -> Unit)? = null

    fun onProgress(func: (progress: Double) -> Unit): EasingManager {
        this.onProgress = func
        return this
    }

    fun onStart(func: () -> Unit): EasingManager {
        this.onStart = func
        return this
    }

    fun onEnd(func: () -> Unit): EasingManager {
        this.onEnd = func
        return this
    }

    fun ease() {
        val previousTime = System.currentTimeMillis()
        onStart?.invoke()
        ticker.onTick { time ->
            val deltaTime = time - previousTime
            var progress = deltaTime / duration
            if (deltaTime >= duration) {
                cancel()
                onEnd?.invoke()
            }
            progress = progress.coerceAtMost(1.0f)
            onProgress?.invoke(ease.calculate(progress))
        }
    }

    fun cancel() = ticker.cancel()
}