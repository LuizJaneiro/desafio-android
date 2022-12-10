package com.picpay.desafio.android.mappers

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.ui.model.User

fun UserModel.toUi() =
    User(
        name = this.name,
        username = this.username,
        img = this.img,
        id = this.id
    )