package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adilmas13.library.*
import com.android_easing.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var easing: EasingManager? = null

    private val list = mutableListOf<Ease>().apply {
        add(Linear())
        add(EaseInSine())
        add(EaseOutSine())
        add(EaseInOutSine())

        add(EaseInCubic())
        add(EaseOutCubic())
        add(EaseInOutCubic())

        add(EaseInQuint())
        add(EaseOutQuint())
        add(EaseInOutQuint())

        add(EaseInCirc())
        add(EaseOutCirc())
        add(EaseInOutCirc())

        add(EaseInElastic())
        add(EaseOutElastic())
        add(EaseInOutElastic())

        add(EaseInQuad())
        add(EaseOutQuad())
        add(EaseInOutQuad())

        add(EaseInQuart())
        add(EaseOutQuart())
        add(EaseInOutQuart())

        add(EaseInExpo())
        add(EaseOutExpo())
        add(EaseInOutExpo())

        add(EaseInBack())
        add(EaseOutBack())
        add(EaseInOutBack())

        add(EaseInBounce())
        add(EaseOutBounce())
        add(EaseInOutBounce())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvEase.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = EaseAdapter(list) { ease ->
                binding.tvEase.text = ease.javaClass.simpleName
                binding.graph.clear()
                easing?.destroy()
                easing = EasingManager(ease = ease, duration = 2000f)
                    .onProgress { value, progress -> binding.graph.plot(value, progress) }
                easing?.start()
            }
        }
    }
}