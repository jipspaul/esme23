package com.example.myapplication.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    val lastName: String,
    val firstName: String,
    val phoneNumber: String,
    val imgUrl: String,
)

//Json
// {
//     "id": "1",
//     "lastName": "Doe",
//     "firstName": "John",
//     "phoneNumber": "0123456789",
//     "imgUrl": "https://www.google.com"
// }