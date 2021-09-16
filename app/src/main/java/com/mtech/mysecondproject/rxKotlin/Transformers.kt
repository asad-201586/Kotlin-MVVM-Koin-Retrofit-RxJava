package com.mtech.mysecondproject.rxKotlin

import com.mtech.mysecondproject.KotlinBaseViewModel
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object Transformers {

    fun <T> apply(): SingleTransformer<T,T>{
        return SingleTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> Single<T>.useProgress(viewModel: KotlinBaseViewModel): Single<T> {
        return compose {
            it.doOnSubscribe {
                viewModel.showProgress()
            }.doFinally { viewModel.hideProgress() }.doOnSuccess { viewModel.hideProgress() }
                .doOnError { viewModel.hideProgress() }.doOnTerminate { viewModel.hideProgress() }
        }
    }

    fun Disposable.addToDisposable(disposable: CompositeDisposable?) {
        disposable?.add(this)
    }

}