package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android_easing.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val easing = EasingManager(duration = 10000f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        easing.onProgress { binding.graph.plot2(it) }
        binding.btn.setOnClickListener { easing.ease() }
        binding.btnPause.setOnClickListener { easing.cancel() }
    }
}