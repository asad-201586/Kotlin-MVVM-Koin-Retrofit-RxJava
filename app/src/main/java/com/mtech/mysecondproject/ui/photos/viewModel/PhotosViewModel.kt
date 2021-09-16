package com.mtech.mysecondproject.ui.photos.viewModel

import androidx.lifecycle.MutableLiveData
import com.mtech.mysecondproject.BaseViewModel
import com.mtech.mysecondproject.ui.photos.data.PhotosData

class PhotosViewModel: BaseViewModel() {
    private val loaderLiveData = MutableLiveData<Boolean>()
    val loaderObserver get() = loaderLiveData
    private val photosLiveData = MutableLiveData<PhotosData>()
    val photosObserver get() = photosLiveData

    fun getAllPhotos(url: String){
        loaderLiveData.postValue(true)
        getPhotosRepo().getAllPhotos(url = url).subscribeWithProgressAndDisposable3{
            loaderLiveData.postValue(false)
            photosLiveData.postValue(it)
        }
    }
}