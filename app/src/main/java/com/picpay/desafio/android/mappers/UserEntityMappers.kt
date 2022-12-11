package com.picpay.desafio.android.mappers

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.service.database.model.UserEntity
import com.picpay.desafio.android.service.networking.model.UserResponse

fun UserEntity.toResponse() =
    UserResponse(
        name = this.name,
        username = this.username,
        img = this.img,
        id = this.id
    )

fun UserEntity.toDomain() =
    UserModel(
        name = this.name,
        username = this.username,
        img = this.img,
        id = this.id ?: -1
    )