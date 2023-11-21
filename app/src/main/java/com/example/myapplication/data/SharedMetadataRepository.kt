package com.example.myapplication.data

import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.data.models.User
import kotlinx.coroutines.flow.Flow

interface SharedMetadataRepository {

    fun sendMetadata(metadata: SharedMetadata)
    fun getMetadata(userId: String): Flow<SharedMetadata>
}