package com.picpay.desafio.android.di

import com.picpay.desafio.android.networking.PicPayService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    factory { provideService<PicPayService>(get()) }
}

private inline fun <reified T> provideService(retrofit: Retrofit): T = retrofit.create(T::class.java)