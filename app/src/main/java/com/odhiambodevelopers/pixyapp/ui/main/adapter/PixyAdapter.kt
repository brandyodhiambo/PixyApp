package com.odhiambodevelopers.pixyapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.odhiambodevelopers.pixyapp.R
import com.odhiambodevelopers.pixyapp.data.local.PixyEntity
import com.odhiambodevelopers.pixyapp.databinding.PixRowBinding

class PixyAdapter:ListAdapter<PixyEntity,PixyAdapter.MyViewHolder>(COMPARATOR) {

    object COMPARATOR:DiffUtil.ItemCallback<PixyEntity>() {
        override fun areItemsTheSame(oldItem: PixyEntity, newItem: PixyEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PixyEntity, newItem: PixyEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }


    inner class MyViewHolder(private val binding: PixRowBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(pix: PixyEntity?) {
            Glide.with(binding.image)
                .load(pix?.webformatURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.image)
            binding.posterName.text = pix?.user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(PixRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pix = getItem(position)
        holder.bind(pix)
    }
}