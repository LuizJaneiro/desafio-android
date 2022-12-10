package com.picpay.desafio.android.mappers

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.networking.model.UserResponse

fun UserResponse.toDomain() =
    UserModel(
        name = this.name,
        username = this.username,
        img = this.img,
        id = this.id
    )