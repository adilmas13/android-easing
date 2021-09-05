package com.android_easing

import android.util.Log
import java.util.*

class EasingManager {
    private var onStart: (() -> Unit)? = null
    private var onEnd: (() -> Unit)? = null
    private var onProgress: ((progress: Float) -> Unit)? = null
    val timer = Timer()
    private var fps = 60L

    fun ease() {
        val duration = 5 * 1000f
        val previousTime = System.currentTimeMillis()
        val timerTask = object : TimerTask() {
            override fun run() {
                val deltaTime = System.currentTimeMillis() - previousTime
                val progress = deltaTime / duration
                if (deltaTime >= duration) {
                    cancel();
                }
            }
        }
        timer.scheduleAtFixedRate(timerTask, 0, 1000 / fps)
    }

    fun cancel() {
        Log.d("WOOOW", "CANCELLING")
        timer.cancel()
    }
}