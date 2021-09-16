package com.mtech.mysecondproject.model


import com.google.gson.annotations.SerializedName

open class CommonResponse(
    @SerializedName("message")
    var message: String = "",
    @SerializedName("status")
    var status: Boolean = false,
    var statusCode: Int = 200
)