package com.android_easing

import java.util.*

class Ticker {
    private val timer = Timer()
    private var fps = 60f

    constructor(fps: Float = 60f) {
        this.fps = fps
    }

    fun onTick(tick: (time: Long) -> Unit) {
        val timerTask = object : TimerTask() {
            override fun run() {
                tick(System.currentTimeMillis())
            }
        }
        timer.scheduleAtFixedRate(timerTask, 0, 16)
    }

    fun cancel() = timer.cancel()
}