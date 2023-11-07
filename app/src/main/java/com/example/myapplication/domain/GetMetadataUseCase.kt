package com.example.myapplication.domain

import com.example.myapplication.data.SharedMetadataRepository
import com.example.myapplication.data.models.SharedMetadata
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMetadataUseCase(private val sharedMetadataRepository: SharedMetadataRepository) {
    fun getMetadata(userId: String): SharedMetadata {
        return sharedMetadataRepository.getMetadata(userId)
    }
}