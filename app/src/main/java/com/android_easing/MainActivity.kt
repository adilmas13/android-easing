package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android_easing.databinding.ActivityMainBinding
import com.android_easing.easing.EaseInOutElastic


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val easing =
            EasingManager(ease = EaseInOutElastic(), duration = 2000f)
                .onProgress { binding.graph.plot2(it) }
        binding.btn.setOnClickListener { easing.ease() }
        binding.btnPause.setOnClickListener { easing.cancel() }
    }
}