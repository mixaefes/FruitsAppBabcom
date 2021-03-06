package com.example.fruitsappbabcom.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.fruitsappbabcom.data.Fruit
import com.example.fruitsappbabcom.databinding.ListFruitItemBinding

class FruitsListAdapter(
    private val listener:OnItemClickListener
) : ListAdapter<Fruit,FruitViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListFruitItemBinding.inflate(inflater,parent,false)
        return FruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { listener.onItemClick(position) }
    }
companion object{
    val itemComparator = object : DiffUtil.ItemCallback<Fruit>(){
        override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
            return oldItem.name == newItem.name
        }

    }
}
}