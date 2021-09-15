package com.mtech.mysecondproject.ui.main.repo

import com.mtech.mysecondproject.ui.main.data.PostData
import com.mtech.mysecondproject.network.apiHitter
import com.mtech.mysecondproject.rxKotlin.Transformers
import io.reactivex.Single

class MainRepo {
    fun getPostData(): Single<PostData>{
        return apiHitter().getPostData().compose(Transformers.apply())
    }
}