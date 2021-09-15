package com.mtech.mysecondproject.ui.main.data


import com.google.gson.annotations.SerializedName

class PostData : ArrayList<PostData.PostDataItem>(){
    data class PostDataItem(
        @SerializedName("body")
        val body: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("userId")
        val userId: Int
    )
}