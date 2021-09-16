package com.mtech.mysecondproject.network

import com.mtech.mysecondproject.ui.main.data.PostData
import com.mtech.mysecondproject.ui.photos.data.PhotosData
import com.mtech.mysecondproject.ui.reg.data.RegData
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET("posts")
    fun getAllPosts(): Single<PostData>

    @FormUrlEncoded
    @POST("/api/register")
    fun registerUser(
        @Field("name") name: String?,
        @Field("mobile") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,
        @Field("password_confirmation") password_confirmation: String?,
        @Field("registration_mode") registration_mode: String?
    ): Single<RegData>

    @GET
    fun getPhotos(
            @Url url:String
    ): Single<PhotosData>

}