package com.picpay.desafio.android.mappers

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.service.database.model.UserEntity
import com.picpay.desafio.android.service.networking.model.UserResponse

fun getUserEntity() =  UserEntity(
    name = "Pessoa Teste",
    id = 2,
    img = "Imagem Url",
    username = "PessoaTeste"
)

fun getUserModel() = UserModel(
    name = "Pessoa Teste",
    id = 2,
    img = "Imagem Url",
    username = "PessoaTeste"
)

fun getUserResponse() = UserResponse(
    name = "Pessoa Teste",
    id = 2,
    img = "Imagem Url",
    username = "PessoaTeste"
)

fun getNullUserResponse() = UserResponse(
    name = null,
    id = null,
    img = null,
    username = null
)