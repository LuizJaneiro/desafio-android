package com.picpay.desafio.android.domain.repository.impl

import com.picpay.desafio.android.domain.model.UserModel
import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.utils.result.PicPayResult
import com.picpay.desafio.android.domain.utils.result.map
import com.picpay.desafio.android.domain.utils.result.mapFailure
import com.picpay.desafio.android.domain.utils.result.result
import com.picpay.desafio.android.mappers.toDomain
import com.picpay.desafio.android.mappers.toEntity
import com.picpay.desafio.android.service.database.UserDatabaseDao
import com.picpay.desafio.android.service.database.UsersDatabase
import com.picpay.desafio.android.service.networking.PicPayNetworking
import com.picpay.desafio.android.service.networking.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class PicPayRepositoryImpl(
    private val service: PicPayNetworking,
    private val database: UserDatabaseDao
): PicPayRepository {
    override suspend fun getUsers(): PicPayResult<List<UserModel>> {
        val result = result {
            service.getUsers()
        }
        if(!result.isFailure) {
            return result.value?.let { responseValue ->
                val response = responseValue as List<*>
                insertUsersInCache(response)
                PicPayResult(
                    response.map { item -> (item as UserResponse).toDomain() }
                )
            } ?: kotlin.run {
                PicPayResult(emptyList<UserModel>())
            }
        } else {
            return try {
                val databaseItems = database.getAllUsers()
                PicPayResult(
                    databaseItems.map { item ->
                        item.toDomain()
                    }
                )
            } catch (t: Throwable) {
                PicPayResult.failure(t)
            }
        }
    }

    private suspend fun insertUsersInCache(list: List<*>) {
        try {
            database.deleteAll()
            list.forEach { item ->
                database.insert((item as UserResponse).toEntity())
            }
        } catch (t: Throwable) {
            // todo: adicionar log
        }
    }
}