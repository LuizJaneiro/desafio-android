package com.picpay.desafio.android.service.networking

import com.picpay.desafio.android.service.networking.model.UserResponse
import retrofit2.http.GET

internal interface PicPayNetworking {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}