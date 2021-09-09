package com.android_easing.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adilmas13.library.*
import com.android_easing.EaseAdapter

class EaseRecyclerView(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

    private var onSelectCallback: ((ease: Ease) -> Unit)? = null
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

    init {
        setup()
    }

    private fun setup() {
        layoutManager = LinearLayoutManager(context)
        adapter = EaseAdapter(list) { onSelectCallback?.invoke(it) }
    }

    fun onSelect(callback: (ease: Ease) -> Unit) {
        this.onSelectCallback = callback
    }
}