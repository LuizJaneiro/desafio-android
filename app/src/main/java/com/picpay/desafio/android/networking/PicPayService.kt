package com.picpay.desafio.android.networking

import com.picpay.desafio.android.networking.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

internal interface PicPayService {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}