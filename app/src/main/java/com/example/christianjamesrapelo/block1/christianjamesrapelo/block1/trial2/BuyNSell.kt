package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2

import android.app.Application
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.RetrofitClient.setSharedPreferences
class BuyNSell : Application() {
    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE)
        setSharedPreferences(sharedPreferences)
    }
}