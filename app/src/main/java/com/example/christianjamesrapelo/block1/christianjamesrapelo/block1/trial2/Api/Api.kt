package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api

import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.DefaultResponse
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.FeaturedProductApi
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.LatestProductsApi
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT

interface Api {
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @PUT("account/update-profile")
    fun updateUser(
        @Header("Authorization") authToken: String,
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("phone") phone:String,
    ): retrofit2.Call<DefaultResponse>

    @Headers("Accept: application/json")
    @GET("account/profile")
    fun getUser(@Header("Authorization") authToken: String): Call<User>

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("account/register")
    fun createUser(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("password_confirmation") confirmpassword: String,
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