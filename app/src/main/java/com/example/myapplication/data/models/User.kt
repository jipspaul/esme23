package com.example.myapplication.data.models

data class User(
    val id: String,
    val lastName: String,
    val firstName: String,
    val privateData: PrivateData,
)
