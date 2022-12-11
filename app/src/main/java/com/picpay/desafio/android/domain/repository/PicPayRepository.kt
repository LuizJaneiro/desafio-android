package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.domain.utils.result.PicPayResult

internal interface PicPayRepository {
    suspend fun getUsers(): PicPayResult
}