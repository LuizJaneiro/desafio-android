package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.utils.result.PicPayResult
import com.picpay.desafio.android.domain.utils.result.map
import com.picpay.desafio.android.domain.utils.result.mapFailure
import com.picpay.desafio.android.domain.utils.usecase.UseCase
import com.picpay.desafio.android.mappers.toUi
import com.picpay.desafio.android.ui.model.User

internal class GetUsersUseCase(
    private val repository: PicPayRepository
) : UseCase<List<User>, Unit>() {
    override suspend fun execute(params: Unit): PicPayResult<List<User>> =
        repository.getUsers().map { userList -> userList.map { item -> item.toUi() } }.mapFailure()
}