package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adilmas13.library.*
import com.android_easing.databinding.ActivityImageBinding


class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    private var easing: EasingManager? = null

    private val list = mutableListOf<Ease>().apply {
        add(Linear())
        add(EaseInSine())
        add(EaseOutSine())
        add(EaseInOutSine())
        add(EaseInElastic())
        add(EaseOutElastic())
        add(EaseInOutElastic())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvEase.apply {
            layoutManager = LinearLayoutManager(this@ImageActivity)
            adapter = EaseAdapter(list) { ease ->
                easing?.destroy()
                easing = EasingManager(ease = ease, duration = 2000f)
                    .onProgress { value, _ ->
                    binding.ivImage.alpha = value.toFloat()
                }
                easing?.start()
            }
        }
    }
}