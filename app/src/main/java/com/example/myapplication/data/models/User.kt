package com.example.myapplication.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    val lastName: String,
    val firstName: String,
    val privateData: PrivateData,
)
