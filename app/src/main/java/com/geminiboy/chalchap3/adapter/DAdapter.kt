package com.geminiboy.chalchap3.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.chalchap3.databinding.ListItemWordBinding

class DAdapter(private val list: List<String>): RecyclerView.Adapter<DAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: String) {
            binding.btnWord.text = list
            binding.btnWord.setOnClickListener {
                val uri = Uri.parse("https://www.google.com/search?q=${list}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DAdapter.ViewHolder = ViewHolder(
        ListItemWordBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
    override fun onBindViewHolder(holder: DAdapter.ViewHolder, position: Int) = holder.bind(list[position])
    override fun getItemCount(): Int
        = list.size

}