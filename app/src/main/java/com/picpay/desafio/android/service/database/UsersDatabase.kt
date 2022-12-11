package com.picpay.desafio.android.service.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.service.database.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
internal abstract class UsersDatabase : RoomDatabase() {

    abstract val userDatabaseDao: UserDatabaseDao

}