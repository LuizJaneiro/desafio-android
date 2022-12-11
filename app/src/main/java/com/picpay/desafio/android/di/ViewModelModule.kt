package com.picpay.desafio.android.di

import com.picpay.desafio.android.ui.get_users.GetUsersViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        GetUsersViewModel(getUsersUseCase = get(), dispatcher = Dispatchers.IO)
    }
}