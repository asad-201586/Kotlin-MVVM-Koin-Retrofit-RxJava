package com.mtech.mysecondproject.network

import com.mtech.mysecondproject.main.data.PostData
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getPostData(): Single<PostData>

    @GET("posts")
    fun getPostData2(): Single<PostData>

}