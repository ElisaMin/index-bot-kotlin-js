package com.github.kotlintelegrambot.entities.payments

import com.github.kotlintelegrambot.entities.User
import java.math.BigInteger

/**
 *
 * This object contains information about an incoming pre-checkout query.
 *
 * @property [id] Unique query identifier
 * @property [from] User who sent the query
 * @property [currency] Three-letter ISO 4217 currency code
 * @property [totalAmount] Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145.
 * @property [invoicePayload] Bot specified invoice payload
 * @property [shippingOptionId] Identifier of the shipping option chosen by the user
 * @property [orderInfo] Order info provided by the user
 * @see OrderInfo
 */
data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: String,
    val total_amount: BigInteger,
    val invoice_payload: String,
    val shipping_option_id: String?,
    val order_info: OrderInfo?,
)
