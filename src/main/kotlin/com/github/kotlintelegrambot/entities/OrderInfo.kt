package com.github.kotlintelegrambot.entities

data class OrderInfo(
    val name: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val shipping_address: ShippingAddress? = null,
)
