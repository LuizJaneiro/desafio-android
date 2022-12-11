package com.picpay.desafio.android.domain.utils.result

import com.picpay.desafio.android.domain.utils.failure.Failure

open class PicPayResult @PublishedApi internal constructor(
    @PublishedApi
    internal val value: Any? = null
){
    val isFailure: Boolean = value is Throwable

    fun exceptionOrNull(): Throwable? = when {
        isFailure -> value as Throwable?
        else -> null
    }
    companion object {
        fun <T> success(value: T): PicPayResult = PicPayResult(value)
        fun failure(throwable: Throwable): PicPayResult = PicPayResult(throwable)
    }
}

inline fun <T> PicPayResult.onSuccess(block: (T) -> Unit): PicPayResult {
    if(!isFailure) block(value as T)
    return this
}

inline fun <T> PicPayResult.onFailure(block: (Throwable) -> Unit): PicPayResult {
    exceptionOrNull()?.let { block(it) }
    return this
}

inline fun <T> result(block: () -> T): PicPayResult = try {
    PicPayResult.success(block())
} catch (throwable: Throwable) {
    PicPayResult.failure(throwable)
}

inline fun <reified T : Throwable> PicPayResult.throwableMap(noinline block: (T) -> Throwable): PicPayResult =
    try {
        when (val exception = exceptionOrNull()) {
            null -> this
            else -> if(exception is T) PicPayResult.failure(block(exception)) else this
        }
    } catch (t: Throwable) {
        PicPayResult.failure(t)
    }

fun <T> PicPayResult.mapFailure(): PicPayResult =
    this.throwableMap<Throwable> { if(it !is Failure) Failure.UnknownFailure(it) else it }

fun <T, R> PicPayResult.map(transform: (value: T) -> R): PicPayResult =
    when {
        this.isFailure -> PicPayResult(this.value)
        else -> result { transform(this.value as T) }
    }

