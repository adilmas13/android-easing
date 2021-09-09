package com.android_easing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adilmas13.library.Ease
import com.android_easing.databinding.AdapterEaseBinding

class EaseAdapter(var eases: List<Ease>, var onClick: (ease: Ease) -> Unit) :
    RecyclerView.Adapter<EaseAdapter.EaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EaseViewHolder {
        return EaseViewHolder(AdapterEaseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: EaseViewHolder, position: Int) {
        holder.bind(eases[position])
    }

    override fun getItemCount() = eases.size

    inner class EaseViewHolder(var binding: AdapterEaseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ease: Ease) {
            binding.tvEase.text = ease.javaClass.simpleName
            binding.root.setOnClickListener { onClick(ease) }
        }
    }
}