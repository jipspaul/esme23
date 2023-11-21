package com.example.myapplication.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.RoomUserRepository
import com.example.myapplication.data.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): RoomUserRepository
}