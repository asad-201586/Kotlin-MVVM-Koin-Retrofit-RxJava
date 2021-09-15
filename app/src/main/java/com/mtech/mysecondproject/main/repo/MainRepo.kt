package com.mtech.mysecondproject.main.repo

import com.mtech.mysecondproject.main.data.PostData
import com.mtech.mysecondproject.network.apiHitter
import com.mtech.mysecondproject.rxKotlin.Transformers
import io.reactivex.Single
import javax.xml.transform.Transformer

class MainRepo {
    fun getPostData(): Single<PostData>{
        return apiHitter().getPostData().compose(Transformers.apply())
    }
}