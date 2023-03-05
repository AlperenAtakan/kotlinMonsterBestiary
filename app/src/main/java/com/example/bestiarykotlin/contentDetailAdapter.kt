package com.example.bestiarykotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import com.example.bestiarykotlin.databinding.RecyclerRow1Binding
import com.example.bestiarykotlin.databinding.RecyclerRowBinding

class contentDetailAdapter (val contentDetailList:ArrayList<ContentDetail>):RecyclerView.Adapter<contentDetailAdapter.ContentDetailHolder>(){

    class ContentDetailHolder(val binding: RecyclerRow1Binding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentDetailHolder {
        val binding=RecyclerRow1Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContentDetailHolder(binding)
    }

    override fun getItemCount(): Int {
       return contentDetailList.size
    }

    override fun onBindViewHolder(holder: ContentDetailHolder, position: Int) {

        holder.binding.recyclerViewTextView1.text=contentDetailList.get(position).monster_name
        holder.itemView.setOnClickListener {
            val intent=Intent(holder.itemView.context,DetailActivity22::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }
}