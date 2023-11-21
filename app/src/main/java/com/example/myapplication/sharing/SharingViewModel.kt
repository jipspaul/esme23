package com.example.myapplication.sharing

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.UserRepository
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SharingViewModel : ViewModel() {

    fun getQrCode() = flow {
        emit(Gson().toJson(UserRepository.getInstance().getMainUser()).toString())
    }

    fun getTimer() = flow {
        delay(5000)
        emit(false)
    }


}