package com.mtech.mysecondproject.ui.reg.viewModel

import androidx.lifecycle.MutableLiveData
import com.mtech.mysecondproject.ui.main.BaseViewModel
import com.mtech.mysecondproject.ui.main.data.reg.RegData

class RegisterViewModel: BaseViewModel() {
    private val regLiveData = MutableLiveData<RegData>()
    val regObserver get() = regLiveData
    private val loaderLiveData = MutableLiveData<Boolean>()
    val loaderObserver get() = loaderLiveData

    fun registerUser(name: String, mobile: String, email: String, password: String){
        loaderLiveData.postValue(true)
        getRegRepo().registerUser(name,mobile,email,password).subscribeWithProgressAndDisposable2{
            loaderLiveData.postValue(false)
            regLiveData.postValue(it)
        }

    }
}