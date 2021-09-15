package com.mtech.mysecondproject.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mtech.mysecondproject.databinding.ItemPostBinding
import com.mtech.mysecondproject.main.data.PostData

class MyAdapter(
    private val context: Context,
    private val postData: PostData
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
        var textTitle:TextView = binding.textTitle
        var textBody:TextView = binding.textBody
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemPostBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = postData[position]
        holder.textTitle.text = data.title
        holder.textBody.text = data.body
    }

    override fun getItemCount(): Int {
        return postData.size
    }
}