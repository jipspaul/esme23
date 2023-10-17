package com.example.myapplication.data

import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.data.models.User

interface SharedMetadataRepository {

    fun sendMetadata(metadata: SharedMetadata)
    fun getMetadata(userId: User): SharedMetadata
}