package com.android_easing

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android_easing.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val easing = EasingManager()
        binding.btn.setOnClickListener {
            //testEasing()
            easing.ease()
        }
        binding.btnPause.setOnClickListener {
           // testEasing()
            easing.cancel()
        }
    }

    private fun testEasing() {


        val duration = 5f
        val animator = ValueAnimator.ofFloat(0f, duration)
        animator.duration = (duration * 1000).toLong()
        animator.addUpdateListener {
            val x = it.animatedValue.toString().toFloat() / duration
//            val result =  1 - kotlin.math.cos((x * PI) / 2);

//val result = 1 - (1 - x).pow(3);
            val result = x * x * x * x * x
//            binding.graph.plot2(result)
            binding.graph.plot2(easeOutElastic(x))
        }
        animator.start()
    }

    private fun easeOutElastic(x: Float): Float {
        val c4 = (2 * Math.PI) / 3
        return when (x) {
            0f -> 0f
            1f -> 1f
            else -> Math.pow(2.0, -10.0 * x).toFloat() * Math.sin((x * 10.0 - 0.75) * c4)
                .toFloat() + 1f
        }
    }

}