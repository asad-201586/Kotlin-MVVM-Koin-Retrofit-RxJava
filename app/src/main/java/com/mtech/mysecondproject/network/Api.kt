package com.mtech.mysecondproject.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Api {

    companion object{
        private const val API_BASE_URL = "https://jsonplaceholder.typicode.com" // get post data (GET() method) and photos by album id (GET() method)
        //private const val API_BASE_URL = "https://money2gotest.nahidatech.com" // register user (POST() method)

        private val instance by lazy { Api().createService() }
        fun getService() = instance
    }

    fun createService(): ApiInterface{
        val client = OkHttpClient().newBuilder()
            .callTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(3,TimeUnit.MINUTES)
            .writeTimeout(3,TimeUnit.MINUTES)

        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .client(client.build())
            .build()

        return retrofit.create(ApiInterface::class.java)

    }
}

fun apiHitter(): ApiInterface{
    return Api.getService()
}