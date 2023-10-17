package com.example.myapplication.data

import com.example.myapplication.data.models.Location

interface LocationRepository {

    fun getCurrentLocation(): Location
    fun getSafePlaces(userId: String): List<Location>
    fun setSafePlaces(locations: List<Location>)


}