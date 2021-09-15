package com.mtech.mysecondproject.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.mtech.mysecondproject.KotlinBaseViewModel
import com.mtech.mysecondproject.main.data.PostData
import com.mtech.mysecondproject.main.repo.MainRepo
import com.mtech.mysecondproject.rxKotlin.Transformers.useProgress
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel: KotlinBaseViewModel(),KoinComponent {
    private val mainRepository: MainRepo by inject()

    fun getMainRepo(): MainRepo{
        return mainRepository
    }
    fun <T> Single<out T>.subscribeWithProgressAndDisposable(success: ((T) -> Unit)? = null) where T : PostData {
        useProgress(this@BaseViewModel).subscribeWithDisposable(success)
    }

    fun <T> Single<out T>.subscribeWithDisposable(success: ((T) -> Unit)? = null) where T : PostData {
        subscribe(
            {

                success?.invoke(it)

            }, {
                Log.e("error_", "subscribeWithDisposable: error: ${it.message}")
            }
        ).addToDisposable(disposables)
    }

    private fun Disposable.addToDisposable(disposable: CompositeDisposable?) {
        disposable?.add(this)
    }

}