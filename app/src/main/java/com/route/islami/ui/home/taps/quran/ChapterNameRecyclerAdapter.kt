package com.route.islami.ui.home.taps.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemChapterNameBinding

class ChapterNameRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<ChapterNameRecyclerAdapter.viewHolder>() {

    class viewHolder(val viewBinding: ItemChapterNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBiniding =
            ItemChapterNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(viewBiniding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.title.text = names[position]
        if (onItemClickListener != null) {
            holder.viewBinding.root.setOnClickListener {
                onItemClickListener?.onItemClick(
                    position,
                    names[position]
                )
            }
        }
    }

    override fun getItemCount(): Int = names.size

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, name: String)
    }


}