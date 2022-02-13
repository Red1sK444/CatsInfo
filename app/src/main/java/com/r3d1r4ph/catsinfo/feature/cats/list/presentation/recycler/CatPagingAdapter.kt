package com.r3d1r4ph.catsinfo.feature.cats.list.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.r3d1r4ph.catsinfo.R
import com.r3d1r4ph.catsinfo.databinding.ItemRecyclerBinding
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatItem

class CatPagingAdapter(private val listener: (CatItem) -> Unit) :
    PagingDataAdapter<CatItem, CatPagingAdapter.ViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<CatItem>() {
            override fun areItemsTheSame(oldItem: CatItem, newItem: CatItem) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CatItem, newItem: CatItem) = oldItem == newItem

        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRecyclerBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                getItem(bindingAdapterPosition)?.let { it1 ->
                    listener.invoke(it1)
                }
            }
        }

        fun bind(catItem: CatItem) {
            binding.itemImageView.load(catItem.url)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler, parent, false)
        )
    }

}