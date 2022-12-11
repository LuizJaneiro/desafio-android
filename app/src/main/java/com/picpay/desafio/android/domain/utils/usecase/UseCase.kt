package com.picpay.desafio.android.domain.utils.usecase

import com.picpay.desafio.android.domain.utils.result.PicPayResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out T, in P> {
    protected abstract suspend fun execute(params: P): PicPayResult

    suspend operator fun invoke(params: P): PicPayResult = withContext(Dispatchers.IO) {
        try {
            execute(params)
        } catch (t: Throwable) {
            PicPayResult.failure(t)
        }
    }
}