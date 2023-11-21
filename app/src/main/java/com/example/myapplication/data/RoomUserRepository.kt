package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomUserRepository {
    @Query("SELECT * FROM user_table ")
    fun getFollowedUser(): Flow<List<User>>

    @Insert
    fun insert(user: User)

}