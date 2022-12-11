package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.networkingModule
import com.picpay.desafio.android.di.repositoryModule
import com.picpay.desafio.android.di.serviceModule
import com.picpay.desafio.android.di.useCaseModule
import com.picpay.desafio.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(
                listOf(
                    networkingModule,
                    repositoryModule,
                    serviceModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}