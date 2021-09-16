package com.mtech.mysecondproject.ui.photos.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mtech.mysecondproject.R
import com.mtech.mysecondproject.databinding.ItemAlbumBinding
import com.mtech.mysecondproject.ui.photoDetails.PhotoDetailsActivity
import com.mtech.mysecondproject.ui.photos.data.PhotosData
import com.squareup.picasso.Picasso


class PhotosAdapter(
    private val context:Context,
    private val albumData: PhotosData
) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {


    class PhotosViewHolder(binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root){
        var imageAlbum = binding.imageAlbum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(ItemAlbumBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val model = albumData[position]
        loadImage(holder.imageAlbum,model)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, PhotoDetailsActivity::class.java)
            intent.putExtra("data", model)
            context.startActivity(intent)

        }
    }

    private fun loadImage(imageAlbum: ImageView, model: PhotosData.PhotosDataItem) {
        Picasso.get().load(model.url).fit().centerCrop()
            .placeholder(R.drawable.octopi_logo)
            .into(imageAlbum)
    }

    override fun getItemCount(): Int {
        if (albumData.isNotEmpty()) return albumData.size
        return 0
    }

}