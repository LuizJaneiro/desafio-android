package com.picpay.desafio.android.service.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "img")
    val img: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "user_name")
    val username: String
)
