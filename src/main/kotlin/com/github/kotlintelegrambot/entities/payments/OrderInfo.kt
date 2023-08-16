package com.github.kotlintelegrambot.entities.payments

/**
 *
 * This object represents information about an order.
 *
 * @property [name] User name
 * @property [phoneNumber] User's phone number
 * @property [email] User email
 * @property [shippingAddress] User shipping address
 * @see ShippingAddress
 */
data class OrderInfo(
    val name: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val shipping_address: ShippingAddress? = null,
)
