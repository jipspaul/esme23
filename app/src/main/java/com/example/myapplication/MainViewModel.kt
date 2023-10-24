package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.HardwareDataProviderImpl
import com.example.myapplication.data.SharedMetadataRepositoryImpl
import com.example.myapplication.domain.BatteryLevelUseCase
import com.example.myapplication.domain.GetMetadataUseCase

class MainViewModel : ViewModel() {

    val getMetadataFlow = GetMetadataUseCase(SharedMetadataRepositoryImpl()).getMetadata("")
    val hardwareDataProvider = HardwareDataProviderImpl()
    val useCase = BatteryLevelUseCase(hardwareDataProvider)

}