package com.github.kotlintelegrambot.entities


data class ShippingAddress(
    val country_code: String,
    val state: String,
    val city: String,
    @JsName("street_line1") val streetLine1: String,
    @JsName("street_line2") val streetLine2: String,
    val post_code: String,
)
