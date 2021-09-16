package com.mtech.mysecondproject.di

import com.mtech.mysecondproject.BaseViewModel
import com.mtech.mysecondproject.ui.main.repo.MainRepo
import com.mtech.mysecondproject.ui.main.viewModel.MainViewModel
import com.mtech.mysecondproject.ui.photos.repo.PhotosRepo
import com.mtech.mysecondproject.ui.photos.viewModel.PhotosViewModel
import com.mtech.mysecondproject.ui.reg.repo.RegRepo
import com.mtech.mysecondproject.ui.reg.viewModel.RegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { BaseViewModel() }
    viewModel { MainViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { PhotosViewModel() }
}

val common = module {
    factory { MainRepo() }
    factory { RegRepo() }
    factory { PhotosRepo() }
}