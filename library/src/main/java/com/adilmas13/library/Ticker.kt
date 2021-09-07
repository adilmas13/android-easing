package com.adilmas13.library

import java.util.*

class Ticker(private var fps: Float = 60f) {
    private val timer = Timer()

    fun onTick(tick: (time: Long) -> Unit) {
        val timerTask = object : TimerTask() {
            override fun run() {
                tick(System.currentTimeMillis())
            }
        }
        timer.scheduleAtFixedRate(timerTask, 0, (1000 / fps).toLong())
    }

    fun cancel() = timer.cancel()

    fun destroy() = timer.purge()
}