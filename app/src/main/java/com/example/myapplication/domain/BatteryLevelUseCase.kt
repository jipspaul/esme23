package com.example.myapplication.domain

import com.example.myapplication.data.HardwareDataProvider

class BatteryLevelUseCase(private val hardwareDataProvider: HardwareDataProvider) {

    fun getBatteryLevel(): Int {
        val batteryStatus = hardwareDataProvider.getBatteryStatus()
        return ((batteryStatus.currentBattery * 100) / batteryStatus.capacity).toInt()
    }

}