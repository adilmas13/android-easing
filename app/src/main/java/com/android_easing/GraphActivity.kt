package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adilmas13.library.EasingManager
import com.android_easing.databinding.ActivityGraphBinding


class GraphActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGraphBinding
    private var easing: EasingManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvEase.onSelect { ease ->
            binding.tvEase.text = ease.javaClass.simpleName
            binding.graph.clear()
            easing?.destroy()
            easing = EasingManager(ease = ease, duration = 2000f)
                .onProgress { value, progress -> binding.graph.plot(value, progress) }
            easing?.start()
        }
    }
}