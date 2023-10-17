package com.example.myapplication.data

interface HardwareDataProvider {
    fun getBatteryStatus(): BatteryStatus
}