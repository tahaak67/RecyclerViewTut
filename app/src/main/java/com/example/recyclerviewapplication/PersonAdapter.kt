package com.example.recyclerviewapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapplication.databinding.PersonItemBinding

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 02,Feb,2023
 */

class PersonAdapter : ListAdapter<Person,RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Person>() {

            override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
                return oldItem.name == newItem.name || oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: PersonItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(val itemBinding: PersonItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(item: Person){
                itemBinding.tvName.text = item.name
                itemBinding.tvName.setOnClickListener {
                    Toast.makeText(it.context,"name: ${item.name}",Toast.LENGTH_LONG).show()
                }
                itemBinding.ivAvatar.setImageResource(item.imageUrl)
            }
    }

}