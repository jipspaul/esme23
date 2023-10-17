package com.example.myapplication.data

import com.example.myapplication.data.models.Location
import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.data.models.User

class SharedMetadataRepositoryImpl : SharedMetadataRepository{
    override fun sendMetadata(metadata: SharedMetadata) {
        TODO("Not yet implemented")
    }

    override fun getMetadata(userId: String): SharedMetadata {
        return SharedMetadata(
            userId = "mnesarchum",
            location = Location(
                name = "Branden Haynes",
                long = 2037,
                lat = 5013
            ),
            batteryStatus = BatteryStatus(
                percentageValue = 2.3,
                capacity = 9088,
                currentBattery = 6509
            ), safePlaces = listOf(),
            privateData = null
        )
    }

}