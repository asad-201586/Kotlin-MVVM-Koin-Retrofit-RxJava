package com.mtech.mysecondproject.ui.reg.repo

import com.mtech.mysecondproject.network.apiHitter
import com.mtech.mysecondproject.rxKotlin.Transformers
import com.mtech.mysecondproject.ui.main.data.reg.RegData
import io.reactivex.Single

class RegRepo {
    fun registerUser(name: String,mobile: String,email: String,password: String): Single<RegData> {
        return apiHitter().registerUser(name = name,mobile = mobile,email = email,password = password,password_confirmation = password,registration_mode = "Manual")
            .compose(Transformers.apply())
    }
}