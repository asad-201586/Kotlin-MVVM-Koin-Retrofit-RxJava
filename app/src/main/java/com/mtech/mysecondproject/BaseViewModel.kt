package com.mtech.mysecondproject

import android.util.Log
import com.mtech.mysecondproject.rxKotlin.Transformers.addToDisposable
import com.mtech.mysecondproject.rxKotlin.Transformers.useProgress
import com.mtech.mysecondproject.ui.main.data.PostData
import com.mtech.mysecondproject.ui.main.repo.MainRepo
import com.mtech.mysecondproject.ui.photos.data.PhotosData
import com.mtech.mysecondproject.ui.photos.repo.PhotosRepo
import com.mtech.mysecondproject.ui.reg.data.RegData
import com.mtech.mysecondproject.ui.reg.repo.RegRepo
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel: KotlinBaseViewModel(),KoinComponent {
    private val mainRepository: MainRepo by inject()
    private val registerRepository: RegRepo by inject()
    private val photosRepository: PhotosRepo by inject()

    fun getMainRepo(): MainRepo{
        return mainRepository
    }

    fun getRegRepo(): RegRepo{
        return registerRepository
    }

    fun getPhotosRepo(): PhotosRepo{
        return photosRepository
    }


    fun <T> Single<out T>.subscribeWithProgressAndDisposable2(success: ((T) -> Unit)? = null) where T : RegData {
        useProgress(this@BaseViewModel).subscribeWithDisposable2(success)
    }

    fun <T> Single<out T>.subscribeWithDisposable2(success: ((T) -> Unit)? = null) where T : RegData {
        subscribe(
            {

                success?.invoke(it)

            }, {
                Log.e("error_", "subscribeWithDisposable: error: ${it.message}")
            }
        ).addToDisposable(disposables)
    }

    fun <T> Single<out T>.subscribeWithProgressAndDisposable3(success: ((T) -> Unit)? = null) where T : PhotosData {
        useProgress(this@BaseViewModel).subscribeWithDisposable3(success)
    }

    fun <T> Single<out T>.subscribeWithDisposable3(success: ((T) -> Unit)? = null) where T : PhotosData {
        subscribe(
            {

                success?.invoke(it)

            }, {
                Log.e("error_", "subscribeWithDisposable: error: ${it.message}")
            }
        ).addToDisposable(disposables)
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

}