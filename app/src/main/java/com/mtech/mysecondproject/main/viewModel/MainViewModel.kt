package com.mtech.mysecondproject.main.viewModel

import androidx.lifecycle.MutableLiveData
import com.mtech.mysecondproject.main.BaseViewModel
import com.mtech.mysecondproject.main.data.PostData

class MainViewModel: BaseViewModel() {
    private val myLiveData = MutableLiveData<PostData>()
    val myObserver get() = myLiveData
    private val loaderLiveData = MutableLiveData<Boolean>()
    val loaderObserver get() = loaderLiveData

    fun getPost(){
        loaderLiveData.postValue(true)
        getMainRepo().getPostData().subscribeWithProgressAndDisposable{
            myLiveData.postValue(it)
            loaderLiveData.postValue(false)
        }
    }
}