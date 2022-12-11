package com.picpay.desafio.android.mappers

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.service.database.model.UserEntity
import com.picpay.desafio.android.service.networking.model.UserResponse

fun UserResponse.toDomain() =
    UserModel(
        name = this.name.orEmpty(),
        username = this.username.orEmpty(),
        img = this.img.orEmpty(),
        id = this.id ?: -1
    )

fun UserResponse.toEntity() =
    UserEntity(
        name = this.name.orEmpty(),
        username = this.username.orEmpty(),
        img = this.img.orEmpty(),
        id = this.id
    )