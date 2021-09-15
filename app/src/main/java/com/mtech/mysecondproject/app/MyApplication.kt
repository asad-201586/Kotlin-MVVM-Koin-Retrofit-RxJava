package com.mtech.mysecondproject.app

import android.app.Application
import com.mtech.mysecondproject.di.common
import com.mtech.mysecondproject.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApplication)
            modules(listOf(common, viewModels))
        }
    }
}