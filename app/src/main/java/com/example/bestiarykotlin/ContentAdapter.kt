package com.example.bestiarykotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bestiarykotlin.databinding.RecyclerRowBinding

class ContentAdapter (val contentList: ArrayList<ContentDetail>):RecyclerView.Adapter<ContentAdapter.ContentHolder>() {

    class ContentHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentHolder {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContentHolder(binding)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: ContentHolder, position: Int) {

        holder.binding.recyclerViewTextView.text=contentList.get(position).typename
        holder.itemView.setOnClickListener {
            val intent=Intent(holder.itemView.context,DetailActivity1::class.java)
            intent.putExtra("content",contentList.get(position))
            intent.putExtra("detaillist",contentList)
            holder.itemView.context.startActivity(intent)
        }
    }
}