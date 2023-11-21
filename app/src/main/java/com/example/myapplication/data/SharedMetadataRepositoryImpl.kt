package com.example.myapplication.data

import com.example.myapplication.data.models.Location
import com.example.myapplication.data.models.SharedMetadata
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SharedMetadataRepositoryImpl : SharedMetadataRepository {
    override fun sendMetadata(metadata: SharedMetadata) {
        TODO("Not yet implemented")
    }

    override fun getMetadata(userId: String): Flow<SharedMetadata> {
        return flow {
            val end = Location("gareDeLyon", 48.8449, 2.3734)
            var currentPoint = Location("gareMontparnasse", 48.8386, 2.3228)

            var shareMetadata = SharedMetadata(
                userId = userId,
                location = currentPoint,
                batteryStatus = BatteryStatus(
                    percentageValue = 2.3,
                    capacity = 9088,
                    currentBattery = 6509
                ), safePlaces = listOf(),
                privateData = null
            )

            while (currentPoint.lat < end.lat || currentPoint.long < end.long) {
                emit(shareMetadata)
                currentPoint = moveTowards(currentPoint, end, 0.00005)
                shareMetadata = shareMetadata.copy(location = currentPoint)

                delay(1000) // Simulate a delay to represent movement over time
            }

            // Add the final point to ensure it reaches the destination
            shareMetadata = shareMetadata.copy(location = end)
            emit(shareMetadata)
        }
    }


    fun moveTowards(start: Location, end: Location, distance: Double): Location {
        val dLat = end.lat - start.lat
        val dLon = end.long - start.long

        val bearing = Math.atan2(dLon, dLat)

        val newLat = start.lat + distance * Math.cos(bearing)
        val newLon = start.long + distance * Math.sin(bearing)

        return Location("", newLat, newLon)
    }


}