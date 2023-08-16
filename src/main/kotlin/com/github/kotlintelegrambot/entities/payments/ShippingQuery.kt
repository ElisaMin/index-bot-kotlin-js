package com.github.kotlintelegrambot.entities.payments

import com.github.kotlintelegrambot.entities.User

data class ShippingQuery(
    val id: String,
    val from: User,
    val invoice_payload: String,
    val shipping_address: ShippingAddress,
)
