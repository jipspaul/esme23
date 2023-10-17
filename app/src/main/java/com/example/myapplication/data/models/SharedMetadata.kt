package com.example.myapplication.data.models

import com.example.myapplication.data.BatteryStatus

data class SharedMetadata(
    val userId: String,
    val location: Location,
    val batteryStatus: BatteryStatus,
    val safePlaces: List<Location>,
    val privateData: PrivateData?,
)
