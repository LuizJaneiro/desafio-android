package com.picpay.desafio.android.ui.model

sealed class ViewModelState<out T> {
    object Loading : ViewModelState<Nothing>()
    data class Success<out R>(val data: R) : ViewModelState<R>()
    data class Error(val error: Throwable) : ViewModelState<Nothing>()
}