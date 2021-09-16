package com.mtech.mysecondproject.ui.photos.repo

import com.mtech.mysecondproject.network.apiHitter
import com.mtech.mysecondproject.rxKotlin.Transformers
import com.mtech.mysecondproject.ui.photos.data.PhotosData
import io.reactivex.Single

class PhotosRepo {
    fun getAllPhotos(url: String): Single<PhotosData>{
        return apiHitter().getPhotos(url).compose(Transformers.apply())
    }
}