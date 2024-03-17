package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api

import android.content.SharedPreferences
import android.util.Base64
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://buyin-n-sellout-dd59ae5ce084.herokuapp.com/api/"
    private lateinit var sharedPreferences: SharedPreferences

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", getAuthToken())
                .build()
            chain.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) // Add logging interceptor
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    fun setSharedPreferences(pref: SharedPreferences) {
        sharedPreferences = pref
    }

    private fun getAuthToken(): String {
        if (!::sharedPreferences.isInitialized) {
            throw IllegalStateException("SharedPreferences has not been initialized. Call setSharedPreferences() before using PHINMAClient.")
        }
        val authToken = sharedPreferences.getString("authToken", "")
        return "Bearer $authToken"
    }

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}