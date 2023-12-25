package com.ikhwanizh.suitmediatest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ikhwanizh.suitmediatest.data.model.Data
import com.ikhwanizh.suitmediatest.databinding.RvItemBinding

class MyRecyclerViewAdapter(private var clickListener: onItemClick): RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    private lateinit var binding: RvItemBinding

    inner class ViewHolder: RecyclerView.ViewHolder(binding.root){
        fun setData(data: Data){
            binding.apply {
                tvFirstName.text = data.firstName
                tvLastName.text = data.lastName
                tvEmail.text = data.email
                Glide.with(itemView.context)
                    .load(data.avatar)
                    .into(image)
            }
        }
        fun itemClick(data: Data, action: onItemClick){
            itemView.setOnClickListener{
                action.setOnItemClick(data, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.itemClick(differ.currentList[position], clickListener)
        holder.setIsRecyclable(false)
    }

    fun differCallback() = object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback())

    interface onItemClick{
        fun setOnItemClick(data: Data, position: Int)
    }
}