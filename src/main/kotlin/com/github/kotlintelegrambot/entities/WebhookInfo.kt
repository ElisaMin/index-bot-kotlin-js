package com.github.kotlintelegrambot.entities

data class WebhookInfo(
    val url: String,
    val has_custom_certificate: Boolean,
    val pending_update_count: Int,
    val ip_address: String?,
    val last_error_date: Long?,
    val last_error_message: String?,
    val max_connections: Int?,
    val allowed_updates: List<String>?,
)
