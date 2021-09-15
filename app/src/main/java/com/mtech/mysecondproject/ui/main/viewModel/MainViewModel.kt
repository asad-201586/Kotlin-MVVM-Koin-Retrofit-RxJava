package com.mtech.mysecondproject.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import com.mtech.mysecondproject.ui.main.BaseViewModel
import com.mtech.mysecondproject.ui.main.data.PostData

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