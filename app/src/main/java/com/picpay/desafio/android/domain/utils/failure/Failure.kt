package com.picpay.desafio.android.domain.utils.failure

sealed class Failure(message: String?, cause: Throwable?) :
    Throwable(message, cause) {

    class UnknownFailure(cause: Throwable?, message: String? = null): Failure(message, cause)

}
