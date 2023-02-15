package com.example.cathomework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cathomework.R
import com.example.cathomework.domain.CatData

class CatAdapter(
    private val listCatData: List<CatData>,
) : RecyclerView.Adapter<CatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_cats, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(listCatData[position])
    }

    override fun getItemCount(): Int = listCatData.size
}