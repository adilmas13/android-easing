package com.android_easing

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android_easing.databinding.ActivityMainBinding
import com.android_easing.easing.EaseInOutElastic
import com.android_easing.easing.EaseInOutSine
import com.android_easing.easing.Linear


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val easing =
            EasingManager(ease = EaseInOutElastic(), duration = 500f)
                .onProgress { value, progress ->
                    binding.graph.plot(value, progress)
                    Log.d("HERE", "$value == $progress")
                }
        binding.btn.setOnClickListener { easing.ease() }
        binding.btnPause.setOnClickListener { easing.cancel() }
    }
}