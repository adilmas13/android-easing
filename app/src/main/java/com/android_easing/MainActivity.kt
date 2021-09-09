package com.android_easing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_easing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvGraph.setOnClickListener { startActivity(Intent(this, GraphActivity::class.java)) }
        binding.tvImage.setOnClickListener { startActivity(Intent(this, ImageActivity::class.java)) }
    }
}