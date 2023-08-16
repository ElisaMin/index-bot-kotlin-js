package com.github.kotlintelegrambot.entities

data class CallbackQuery(
    val id: String,
    val from: User,
    val message: Message? = null,
    val inline_message_id: String? = null,
    val data: String,
    val chat_instance: String,
)
