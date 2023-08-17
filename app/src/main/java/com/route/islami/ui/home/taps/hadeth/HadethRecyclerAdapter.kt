package com.route.islami.ui.home.taps.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemHadethBinding
import com.route.islami.ui.home.model.Hadeth

class HadethRecyclerAdapter(private var items: List<Hadeth>?) :
    RecyclerView.Adapter<HadethRecyclerAdapter.viewHolder>() {

    class viewHolder(val viewBinding: ItemHadethBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBiniding =
            ItemHadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(viewBiniding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.title.text = items!![position].title
        if (onItemClickListener != null) {
            holder.viewBinding.root.setOnClickListener {
                onItemClickListener?.onItemClick(
                    position,
                    items!![position]
                )
            }
        }
    }

    fun bindItem(newList: List<Hadeth>) {
        items = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items?.size ?: 0

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, item: Hadeth)
    }


}