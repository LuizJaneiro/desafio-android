package com.picpay.desafio.android.di

import android.content.Context
import androidx.room.Room
import com.picpay.desafio.android.service.database.UserDatabaseDao
import com.picpay.desafio.android.service.database.UsersDatabase
import com.picpay.desafio.android.service.networking.PicPayNetworking
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    factory { provideService<PicPayNetworking>(get()) }
    single <UsersDatabase> {
        buildDataBase(applicationContext = androidContext())
    }
    single <UserDatabaseDao> {
        val database = get<UsersDatabase>()
        database.userDatabaseDao
    }
}

private inline fun <reified T> provideService(retrofit: Retrofit): T = retrofit.create(T::class.java)

private fun buildDataBase(applicationContext: Context): UsersDatabase =
    Room.databaseBuilder(
        applicationContext,
        UsersDatabase::class.java,
        "user_database"
    )
        .fallbackToDestructiveMigration()
        .build()