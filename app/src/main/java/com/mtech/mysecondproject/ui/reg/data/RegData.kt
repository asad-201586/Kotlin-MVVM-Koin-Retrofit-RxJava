package com.mtech.mysecondproject.ui.reg.data


import com.google.gson.annotations.SerializedName
import com.mtech.mysecondproject.model.CommonResponse

data class RegData(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: User
): CommonResponse() {
    data class User(
        @SerializedName("avatar")
        val avatar: String? = "",
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("email_verified_at")
        val emailVerifiedAt: String? = "",
        @SerializedName("id")
        val id: Int,
        @SerializedName("mobile")
        val mobile: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("registration_mode")
        val registrationMode: String,
        @SerializedName("role_id")
        val roleId: String? = "",
        @SerializedName("status")
        val status: String,
        @SerializedName("updated_at")
        val updatedAt: String
    )
}