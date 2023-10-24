package com.example.myapplication.sharing

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.util.UUID
import java.util.concurrent.Flow

class SharingViewModel : ViewModel() {

    fun getQrCode(): String {
        //TODO send serveur UUID value
        return "esme23:https://esme23.fr/?${UUID.randomUUID()}"
    }

    fun getTimer() = flow {
        delay(5000)
        emit(true)
    }


}