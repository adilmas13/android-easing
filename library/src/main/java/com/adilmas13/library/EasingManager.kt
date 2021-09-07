package com.adilmas13.library

class EasingManager(private var ease: Ease = Linear(), private var duration: Float) {
    private val ticker = Ticker()

    private var onStart: (() -> Unit)? = null
    private var onEnd: (() -> Unit)? = null
    private var onProgress: ((value: Double, progress: Double) -> Unit)? = null

    fun onProgress(func: (value: Double, progress: Double) -> Unit): EasingManager {
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

    fun start() {
        val previousTime = System.currentTimeMillis()
        onStart?.invoke()
        ticker.onTick { time ->
            val deltaTime = time - previousTime
            var progress = (deltaTime / duration).toDouble()
            if (deltaTime >= duration) {
                cancel()
                onEnd?.invoke()
            }
            progress = progress.coerceAtMost(1.0)
            onProgress?.invoke(ease.calculate(progress), progress)
        }
    }

    fun cancel() = ticker.cancel()

    fun destroy() {
        ticker.cancel()
        ticker.destroy()
    }
}