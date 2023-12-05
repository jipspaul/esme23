package com.example.myapplication.data

import android.content.SharedPreferences
import com.example.myapplication.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    companion object {
        private var instance: UserRepository? = null

        fun init(
            roomUserRepository: RoomUserRepository,
            sharedPreferences: SharedPreferences
        ) {
            if (instance == null) {
                instance = UserRepositoryImpl(roomUserRepository, sharedPreferences)
            }
        }

        fun getInstance(): UserRepository {
            return instance!!
        }
    }

    fun getMainUser(): User?
    fun setMainUser(user: User)
    fun getUserById(userId: String): User
    fun follow(user: User)
    fun getFollowedUser(): Flow<List<User>>
    fun getFollowerUser(): List<User>
}