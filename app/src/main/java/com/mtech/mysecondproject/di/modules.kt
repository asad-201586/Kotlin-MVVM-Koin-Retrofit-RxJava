package com.mtech.mysecondproject.di

import com.mtech.mysecondproject.ui.main.BaseViewModel
import com.mtech.mysecondproject.ui.main.repo.MainRepo
import com.mtech.mysecondproject.ui.main.viewModel.MainViewModel
import com.mtech.mysecondproject.ui.reg.repo.RegRepo
import com.mtech.mysecondproject.ui.reg.viewModel.RegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { BaseViewModel() }
    viewModel { MainViewModel() }
    viewModel { RegisterViewModel() }
}

val common = module {
    factory { MainRepo() }
    factory { RegRepo() }
}