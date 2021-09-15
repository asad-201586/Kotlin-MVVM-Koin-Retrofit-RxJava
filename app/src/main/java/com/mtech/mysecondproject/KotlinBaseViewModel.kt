package com.mtech.mysecondproject

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class KotlinBaseViewModel: ViewModel(),LifecycleObserver {
    var disposables: CompositeDisposable = CompositeDisposable()
    private val errorLiveData by lazy { VolatileLiveData<CommonError>() }
    val errorObserver get() = errorLiveData
    private val progressLiveData by lazy { VolatileLiveData<Boolean>() }
    val progressObserver get() = progressLiveData

    fun addToDisposable(disposable: Disposable?) {
        disposable?.let { disposables.add(it) }
    }

    fun showError(errorMSg: String?, errorType: ErrorType = ErrorType.SNACKBAR) {

        errorMSg?.let { errorLiveData.setValue(CommonError(it, errorType)) }
    }

    fun showProgress() {
        progressLiveData.setValue(true)
    }

    fun hideProgress() {
        progressLiveData.setValue(false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        disposables = CompositeDisposable()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposables.clear()
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}