package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model

import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String
)
