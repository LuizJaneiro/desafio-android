package com.picpay.desafio.android.domain.repository.impl

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.utils.result.PicPayResult
import com.picpay.desafio.android.domain.utils.result.map
import com.picpay.desafio.android.domain.utils.result.mapFailure
import com.picpay.desafio.android.domain.utils.result.result
import com.picpay.desafio.android.mappers.toDomain
import com.picpay.desafio.android.networking.PicPayService

internal class PicPayRepositoryImpl(
    private val service: PicPayService
): PicPayRepository {
    override suspend fun getUsers(): PicPayResult<List<UserModel>> {
        return result {
            service.getUsers()
        }.map { response ->
            response.map { item -> item.toDomain() }
        }.mapFailure()
    }
}