package com.example.fruitsappbabcom.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.fruitsappbabcom.data.Fruit
import com.example.fruitsappbabcom.databinding.ListFruitItemBinding

class FruitViewHolder(private val binding: ListFruitItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Fruit) {
        binding.textViewItem.text = item.name
        binding.imageViewItem.load(item.image)
    }
}