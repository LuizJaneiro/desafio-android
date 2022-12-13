package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.domain.model.UserModel

fun getUserModelList() = listOf(
    UserModel(img = "Imagem URL", name = "Nome Pessoa", username = "Pessoa username", id = 1),
    UserModel(img = "Imagem URL", name = "Nome Pessoa", username = "Pessoa username", id = 2)
)