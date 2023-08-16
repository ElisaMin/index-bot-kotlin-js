package com.github.kotlintelegrambot.entities.files

/**
 * Represents a chat photo.
 * https://core.telegram.org/bots/api#chatphoto
 */
data class ChatPhoto(
    val small_file_id: String,
    val small_file_unique_id: String,
    val big_file_id: String,
    val big_file_unique_id: String,
)
