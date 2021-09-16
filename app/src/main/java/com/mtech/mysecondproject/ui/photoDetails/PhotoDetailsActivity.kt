package com.mtech.mysecondproject.ui.photoDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mtech.mysecondproject.R
import com.mtech.mysecondproject.ui.photos.data.PhotosData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_album_details.*

class PhotoDetailsActivity : AppCompatActivity() {
    private var data: PhotosData.PhotosDataItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        getData()
        setData()
    }

    private fun setData() {
        text_album_id.text = data?.albumId.toString()
        text_id.text = data?.id.toString()
        text_title.text = data?.title.toString()

        Picasso.get().load(data?.url).fit().centerCrop()
            .placeholder(R.drawable.octopi_logo)
            .into(image_album)
    }

    private fun getData() {
        if (intent.hasExtra("data")) {
            data = intent.getSerializableExtra("data") as PhotosData.PhotosDataItem
        }
    }
}