package com.github.kotlintelegrambot.entities.files

/**
 * Represents an audio file to be treated as music by the Telegram clients.
 * https://core.telegram.org/bots/api#audio
 */
data class Audio(
    val file_id: String,
    val file_unique_id: String,
    val duration: Int,
    val performer: String? = null,
    val title: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
)
