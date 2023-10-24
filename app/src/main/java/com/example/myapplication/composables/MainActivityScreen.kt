package com.example.myapplication.composables

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
import com.example.myapplication.MainViewModel
import com.example.myapplication.data.models.SharedMetadata


@Composable
fun MainScreen(mainViewModel: MainViewModel) {

    return Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        val sharedMetadata by mainViewModel.getMetadataFlow.collectAsState(
            initial = null
        )

        Column {
            //  BatteryLevel(useCase.getBatteryLevel())
            sharedMetadata?.let { MetadataViewer(it) }
        }
    }
}

@Composable
fun MetadataViewer(metadata: SharedMetadata, modifier: Modifier = Modifier) {
    Text(
        text = metadata.userId,
        modifier = modifier
    )
}