package com.example.cathomework.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cathomework.R
import com.example.cathomework.domain.CatData

class CatViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    fun onBind(item: CatData) {
        val image = itemView.findViewById<ImageView>(R.id.image)

        getPoster(item.catImageUrl, image)
    }

    private fun getPoster(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}