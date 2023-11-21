package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.HardwareDataProviderImpl
import com.example.myapplication.data.SharedMetadataRepositoryImpl
import com.example.myapplication.data.UserRepositoryImpl
import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.domain.BatteryLevelUseCase
import com.example.myapplication.domain.GetMetadataUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _sharedMetaData = MutableStateFlow<SharedMetadata?>(null)
    val sharedMetaData: Flow<SharedMetadata?> = SharedMetadataRepositoryImpl().getMetadata("Mark")


    val hardwareDataProvider = HardwareDataProviderImpl()
    val useCase = BatteryLevelUseCase(hardwareDataProvider)

    fun selectUser(userId: String) {
        viewModelScope.launch {

           // GetMetadataUseCase(.collect {
           //     _sharedMetaData.value = it
           // }
        }
    }
}