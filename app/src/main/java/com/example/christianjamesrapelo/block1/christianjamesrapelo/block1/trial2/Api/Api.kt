package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api

import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.DefaultResponse
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.FeaturedProductApi
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.LatestProductsApi
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("account/process-register")
    fun createUser(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String,

        ):retrofit2.Call<DefaultResponse>

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("account/login")
    fun login(

        @Field("email") email: String,
        @Field("password") password: String
    ):retrofit2.Call<DefaultResponse>

    @Headers("Accept: application/json")
    @GET("latestProducts")
    fun getProducts(): Call<List<LatestProductsApi>>

    @Headers("Accept: application/json")
    @GET("featuredProducts")
    fun getFeaturedProducts(): Call<List<FeaturedProductApi>>
}