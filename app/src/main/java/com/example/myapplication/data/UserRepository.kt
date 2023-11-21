package com.example.myapplication.data

import com.example.myapplication.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getMainUser(): User
    fun setMainUser(user: User)
    fun getUserById(userId: String): User
    fun getFollowedUser(): Flow<List<User>>
    fun getFollowerUser(): List<User>
}