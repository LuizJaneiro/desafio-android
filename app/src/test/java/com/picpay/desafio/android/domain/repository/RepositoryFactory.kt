package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.service.database.model.UserEntity
import com.picpay.desafio.android.service.networking.model.UserResponse

fun getUserEntityList() = listOf(
    UserEntity(img = "Imagem URL", name = "Nome Pessoa", username = "Pessoa username", id = 1),
    UserEntity(img = "Imagem URL", name = "Nome Pessoa", username = "Pessoa username", id = 2)
)

fun getUserResponseList() = listOf(
    UserResponse(img = "Imagem URL", name = "Nome Pessoa", username = "Pessoa username", id = 1),
    UserResponse(img = "Imagem URL", name = "Nome Pessoa", username = "Pessoa username", id = 2)
)