package com.android_easing

class EasingManager {
    private val ticker = Ticker()

    private var onStart: (() -> Unit)? = null
    private var onEnd: (() -> Unit)? = null
    private var onProgress: ((progress: Float) -> Unit)? = null
    private var duration = 0f

    constructor(duration: Float) {
        this.duration = duration
    }

    fun onProgress(func: (progress: Float) -> Unit): EasingManager {
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
        ticker.onTick { time ->
            val deltaTime = time - previousTime
            var progress = deltaTime / duration
            if (deltaTime >= duration) {
                cancel()
            }
            progress = progress.coerceAtMost(1.0f)
            onProgress?.invoke(progress)
        }
    }

    fun cancel() = ticker.cancel()
}