package com.example.myapplication.data

import android.content.SharedPreferences
import com.example.myapplication.data.models.User
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val roomDatabase: RoomUserRepository,
    private val sharedPreferences: SharedPreferences
) : UserRepository {

    override fun getMainUser(): User {
        val user = sharedPreferences.getString("main_user_json", null)
        return if (user != null) {
            Gson().fromJson(user, User::class.java)
        } else {
            val tmpUser = User("1", "Esme", "John", "0123456789", "https://www.google.com")
            sharedPreferences.edit().putString(Gson().toJson(tmpUser), "main_user_json").apply()
            sharedPreferences.getString("main_user_json", null)
                ?.let { Gson().fromJson(it, User::class.java) }!!
        }
    }


    override fun setMainUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(userId: String): User {
        TODO("Not yet implemented")
    }

    override fun follow(user: User) {
        roomDatabase.follow(user)
    }

    override fun getFollowedUser(): Flow<List<User>> {
        return roomDatabase.getFollowedUser()
    }

    override fun getFollowerUser(): List<User> {
        TODO("Not yet implemented")
    }
}