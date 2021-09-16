package com.mtech.mysecondproject.ui.photos.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.mtech.mysecondproject.GridSpacingItemDecoration
import com.mtech.mysecondproject.R
import com.mtech.mysecondproject.ui.photos.adapter.PhotosAdapter
import com.mtech.mysecondproject.ui.photos.viewModel.PhotosViewModel
import kotlinx.android.synthetic.main.activity_photos.*
import org.koin.android.viewmodel.ext.android.viewModel

class PhotosActivity : AppCompatActivity() {
    private val photosViewModel: PhotosViewModel by viewModel()
    private var albumId:Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        setUpRecyclerview()
        getPhotos()
        setUpObserver()
        setUpClickListener()
    }

    private fun setUpClickListener() {
        text_next_album.setOnClickListener {
            albumId = albumId.plus(1)
            getPhotos()
        }

        text_prev_album.setOnClickListener {
            if (albumId > 1) {
                albumId = albumId.minus(1)
                getPhotos()
            }
        }
    }

    private fun setUpObserver() {
        photosViewModel.loaderObserver.observe(this, {
            if (it) loader.visibility = View.VISIBLE
            else loader.visibility = View.GONE
        })

        photosViewModel.photosObserver.observe(this, {

            if (it != null && it.size != 0){
                val adapter = PhotosAdapter(this,it)
                photos_rv.adapter = adapter
                photos_rv.notifyDataSetChanged()
            }else{
                photos_rv.visibility = View.GONE
                text_no_photos_found.visibility = View.VISIBLE
            }

        })
    }

    private fun getPhotos() {
        photosViewModel.getAllPhotos("/photos?albumId=$albumId")
    }

    private fun setUpRecyclerview() {
        photos_rv.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this,2)
        photos_rv.layoutManager = gridLayoutManager
        photos_rv.addItemDecoration(GridSpacingItemDecoration(2,50,true))
    }
}