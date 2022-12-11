package com.picpay.desafio.android.domain.utils.result

import com.picpay.desafio.android.domain.utils.failure.Failure

open class PicPayResult<out R> @PublishedApi internal constructor(
    @PublishedApi
    internal val value: Any? = null
){
    val isFailure: Boolean = value is Throwable

    fun exceptionOrNull(): Throwable? = when {
        isFailure -> value as Throwable?
        else -> null
    }
    companion object {
        fun <T> success(value: T): PicPayResult<T> = PicPayResult(value)
        fun <T> failure(throwable: Throwable): PicPayResult<T> = PicPayResult(throwable)
    }
}

inline fun <T> PicPayResult<T>.onSuccess(block: (T) -> Unit): PicPayResult<T> {
    if(!isFailure) block(value as T)
    return this
}

inline fun <T> PicPayResult<T>.onFailure(block: (Throwable) -> Unit): PicPayResult<T> {
    exceptionOrNull()?.let { block(it) }
    return this
}

inline fun <T> result(block: () -> T): PicPayResult<T> = try {
    PicPayResult.success(block())
} catch (throwable: Throwable) {
    PicPayResult.failure(throwable)
}

inline fun <reified T : Throwable, R> PicPayResult<R>.throwableMap(noinline block: (T) -> Throwable): PicPayResult<R> =
    try {
        when (val exception = exceptionOrNull()) {
            null -> this
            else -> if(exception is T) PicPayResult.failure(block(exception)) else this
        }
    } catch (t: Throwable) {
        PicPayResult.failure(t)
    }

fun <T> PicPayResult<T>.mapFailure(): PicPayResult<T> =
    this.throwableMap<Throwable, T> { if(it !is Failure) Failure.UnknownFailure(it) else it }

fun <T, R> PicPayResult<T?>.map(transform: (value: T) -> R): PicPayResult<R> =
    when {
        this.isFailure -> PicPayResult(this.value)
        else -> result { transform(this.value as T) }
    }

