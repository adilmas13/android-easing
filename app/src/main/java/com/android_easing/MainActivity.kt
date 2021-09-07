package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_easing.databinding.ActivityMainBinding
import com.android_easing.easing.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var easing: EasingManager? = null

    private val list = mutableListOf<Ease>().apply {
        add(Linear())
        add(EaseInSine())
        add(EaseOutSine())
        add(EaseInOutSine())
        add(EaseInOutElastic())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvEase.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = EaseAdapter(list) { ease ->
                easing?.destroy()
                binding.graph.clear()
                easing = EasingManager(ease = ease, duration = 2000f).onProgress { value, progress -> binding.graph.plot(value, progress) }
                easing?.start()
            }
        }
    }
}