package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_easing.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var easing: com.adilmas13.library.EasingManager? = null

    private val list = mutableListOf<com.adilmas13.library.Ease>().apply {
        add(com.adilmas13.library.Linear())
        add(com.adilmas13.library.EaseInSine())
        add(com.adilmas13.library.EaseOutSine())
        add(com.adilmas13.library.EaseInOutSine())
        add(com.adilmas13.library.EaseInElastic())
        add(com.adilmas13.library.EaseOutElastic())
        add(com.adilmas13.library.EaseInOutElastic())
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
                easing = com.adilmas13.library.EasingManager(ease = ease, duration = 2000f)
                    .onProgress { value, progress -> binding.graph.plot(value, progress) }
                easing?.start()
            }
        }
    }
}