package com.example.myapplication.data

import com.example.myapplication.data.models.User

interface UserRepository {

    fun getMainUser(): User
    fun setMainUser(user: User)
    fun getUserById(userId: String): User
    fun getFollowedUser(): List<User>
    fun getFollowerUser(): List<User>
}