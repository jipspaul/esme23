package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.composables.MainScreen
import com.example.myapplication.data.HardwareDataProviderImpl
import com.example.myapplication.data.SharedMetadataRepositoryImpl
import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.domain.BatteryLevelUseCase
import com.example.myapplication.domain.GetMetadataUseCase
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val metaDataFlow by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                MainScreen(metaDataFlow)
            }
        }
    }
}

