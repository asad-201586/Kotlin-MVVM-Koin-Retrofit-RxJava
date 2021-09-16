package com.mtech.mysecondproject.ui.photos.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PhotosData : ArrayList<PhotosData.PhotosDataItem>(){
    data class PhotosDataItem(
        @SerializedName("albumId")
        val albumId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String
    ): Serializable
}