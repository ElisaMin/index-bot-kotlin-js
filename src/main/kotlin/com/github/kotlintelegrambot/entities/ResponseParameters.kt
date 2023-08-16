package com.github.kotlintelegrambot.entities

data class ResponseParameters(
    val migrate_to_chat_id: Long? = null,
    val retry_after: Long? = null,
)
