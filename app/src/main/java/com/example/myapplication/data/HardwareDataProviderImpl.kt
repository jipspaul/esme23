package com.example.myapplication.data

class HardwareDataProviderImpl : HardwareDataProvider {


    override fun getBatteryStatus(): BatteryStatus {

        return BatteryStatus(
            23.0, 30000L, 15000L
        )
    }


}