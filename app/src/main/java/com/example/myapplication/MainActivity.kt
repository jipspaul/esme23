package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.room.Room
import com.example.myapplication.composables.MainScreen
import com.example.myapplication.data.UserRepository
import com.example.myapplication.data.UserRepositoryImpl
import com.example.myapplication.data.dao.AppDatabase
import com.example.myapplication.scanner.ScannerActivity
import com.example.myapplication.sharing.SharingActivity
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val metaDataFlow by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "user-database"
        ).build()
        UserRepository.init(
            db.userDao(),
            applicationContext.getSharedPreferences("user", MODE_PRIVATE)
        )

        setContent {
            MyApplicationTheme {
                MainScreen(
                    metaDataFlow,
                    { onStartSharing() },
                    { onStartScanner() },
                    UserRepository.getInstance()
                )
            }
        }
    }

    private fun onStartSharing() {
        val intent = Intent(this, SharingActivity::class.java)
        startActivity(intent)
    }

    private fun onStartScanner() {
        val intent = Intent(this, ScannerActivity::class.java)
        startActivity(intent)
    }
}