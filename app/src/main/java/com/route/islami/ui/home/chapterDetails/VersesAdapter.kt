package com.route.islami.ui.home.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val biniding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(biniding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.biniding.content.text = verses[position]
    }

    override fun getItemCount(): Int = verses.size
    class ViewHolder(val biniding: ItemVerseBinding) : RecyclerView.ViewHolder(biniding.root) {

    }
}