package com.github.kotlintelegrambot.entities

import com.google.gson.annotations.SerializedName

data class ShippingAddress(
    val country_code: String,
    val state: String,
    val city: String,
    @SerializedName("street_line1") val streetLine1: String,
    @SerializedName("street_line2") val streetLine2: String,
    val post_code: String,
)
