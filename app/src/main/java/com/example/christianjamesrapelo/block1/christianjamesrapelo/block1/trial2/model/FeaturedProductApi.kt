package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model

import com.google.gson.annotations.SerializedName

data class FeaturedProductApi(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
)
