package com.example.myapplication.data

import com.example.myapplication.data.models.PrivateData
import com.example.myapplication.data.models.User

class UserRepositoryImpl : UserRepository {
    override fun getMainUser(): User {
        TODO("Not yet implemented")
    }

    override fun setMainUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(userId: String): User {
        TODO("Not yet implemented")
    }

    override fun getFollowedUser(): List<User> {
        return listOf(
            User(
                "Klara",
                "Klara",
                "Klara",
                PrivateData(
                    "0650000000",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Esme-sudria-logo.png/768px-Esme-sudria-logo.png"
                )
            ),
            User(
                "Mark",
                "Mark",
                "Mark",
                PrivateData(
                    "0650000000",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Esme-sudria-logo.png/768px-Esme-sudria-logo.png"
                )
            ),
            User(
                "Sonia",
                "Sonia",
                "Sonia",
                PrivateData(
                    "0650000000",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Esme-sudria-logo.png/768px-Esme-sudria-logo.png"
                )
            ),
            User(
                "Paul",
                "Paul",
                "Paul",
                PrivateData(
                    "0650000000",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Esme-sudria-logo.png/768px-Esme-sudria-logo.png"
                )
            )
            ,
            User(
                "Thierry",
                "Thierry",
                "Thierry",
                PrivateData(
                    "0650000000",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Esme-sudria-logo.png/768px-Esme-sudria-logo.png"
                )
            )
        )
    }

    override fun getFollowerUser(): List<User> {
        TODO("Not yet implemented")
    }
}