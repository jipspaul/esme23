package com.example.myapplication.data

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.models.PrivateData
import com.example.myapplication.data.models.User
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl (private val roomDatabase: RoomUserRepository) : UserRepository {

    override fun getMainUser(): User {
        TODO("Not yet implemented")
    }

    override fun setMainUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(userId: String): User {
        TODO("Not yet implemented")
    }

    override fun getFollowedUser(): Flow<List<User>> {
        return roomDatabase.getFollowedUser()
    }

    override fun getFollowerUser(): List<User> {
        TODO("Not yet implemented")
    }
}