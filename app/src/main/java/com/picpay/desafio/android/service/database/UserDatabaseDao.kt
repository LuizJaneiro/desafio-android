package com.picpay.desafio.android.service.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.picpay.desafio.android.service.database.model.UserEntity

@Dao
internal interface UserDatabaseDao {

    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM user_data_table")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("DELETE FROM user_data_table")
    suspend fun deleteAll()
}