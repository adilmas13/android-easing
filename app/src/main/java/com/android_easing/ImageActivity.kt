package com.android_easing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adilmas13.library.EasingManager
import com.android_easing.databinding.ActivityImageBinding


class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    private var easing: EasingManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvEase.onSelect { ease ->
            easing?.destroy()
            easing = EasingManager(ease = ease, duration = 2000f)
                .onProgress { value, _ ->
                    binding.ivImage.alpha = value.toFloat()
                }
            easing?.start()
        }
    }
}