package com.geminiboy.chalchap3.adapter

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.chalchap3.R
import com.geminiboy.chalchap3.databinding.ListItemWordBinding.inflate
import com.geminiboy.chalchap3.databinding.ListItemWordBinding
import com.geminiboy.chalchap3.fragment.WordDFragment

class WordAdapter(private val list: List<Char>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Char) {
            binding.btnWord.text = list.toString()

            binding.btnWord.setOnClickListener {
                val appCompatActivity = it.context as AppCompatActivity
                val _fragmentManager = appCompatActivity.supportFragmentManager
                val _detailLetterFragment = WordDFragment()
                val fragment = _fragmentManager.findFragmentByTag(WordDFragment::class.java.simpleName)

                if (fragment !is WordDFragment){
                    val bundel = Bundle()
                    bundel.putString("EXTRA_WORD", list.toString())
                    _detailLetterFragment.arguments = bundel
                    _fragmentManager.beginTransaction().replace(R.id.frameContainer,_detailLetterFragment,WordDFragment::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        inflate(LayoutInflater.from(parent.context),parent,false)
    )
    override fun onBindViewHolder(holder: WordAdapter.ViewHolder, position: Int) =
        holder.bind(list[position])
    override fun getItemCount(): Int = list.size
}