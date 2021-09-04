package com.android_easing

import android.R.attr
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android_easing.databinding.ActivityMainBinding
import android.R.attr.x
import java.lang.Math.*
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            testEasing()
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
            binding.graph.plot(result.toDouble())
        }
        animator.start()
    }
}