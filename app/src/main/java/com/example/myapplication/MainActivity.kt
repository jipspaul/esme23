package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.myapplication.data.HardwareDataProviderImpl
import com.example.myapplication.data.SharedMetadataRepositoryImpl
import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.domain.BatteryLevelUseCase
import com.example.myapplication.domain.GetMetadataUseCase
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val useCaseMetadata = GetMetadataUseCase(SharedMetadataRepositoryImpl())

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val hardwareDataProvider = HardwareDataProviderImpl()
                    val useCase = BatteryLevelUseCase(hardwareDataProvider)

                    val sharedMetadata by useCaseMetadata.getMetadata("toto").collectAsState(
                        initial = null
                    )


                    Column {
                        BatteryLevel(useCase.getBatteryLevel())
                        sharedMetadata?.let { MetadataViewer(it) }
                    }
                }
            }
        }
    }
}


@Composable
fun BatteryLevel(batteryPercent: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Battery Level = $batteryPercent",
        modifier = modifier
    )
}

@Composable
fun MetadataViewer(metadata: SharedMetadata, modifier: Modifier = Modifier) {
    Text(
        text = metadata.userId,
        modifier = modifier
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}