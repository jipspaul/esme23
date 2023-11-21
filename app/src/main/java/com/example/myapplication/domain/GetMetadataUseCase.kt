package com.example.myapplication.domain

import com.example.myapplication.data.SharedMetadataRepository
import com.example.myapplication.data.models.SharedMetadata
import kotlinx.coroutines.flow.Flow

class GetMetadataUseCase(private val sharedMetadataRepository: SharedMetadataRepository) {
    fun getMetadata(userId: String): Flow<SharedMetadata> {
        return sharedMetadataRepository.getMetadata(userId)
    }
}