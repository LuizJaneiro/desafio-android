package com.picpay.desafio.android.di

import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.repository.impl.PicPayRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<PicPayRepository> {
        PicPayRepositoryImpl(
            service = get(),
            database = get()
        )
    }
}