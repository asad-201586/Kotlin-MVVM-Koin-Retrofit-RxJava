package com.mtech.mysecondproject.di

import com.mtech.mysecondproject.main.BaseViewModel
import com.mtech.mysecondproject.main.repo.MainRepo
import com.mtech.mysecondproject.main.viewModel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { BaseViewModel() }
    viewModel { MainViewModel() }
}

val common = module {
    factory { MainRepo() }
}