package com.github.kotlintelegrambot.entities.files

/**
 * Represents a general file (as opposed to photos, voice messages and audio files).
 * https://core.telegram.org/bots/api#document
 */
data class Document(
    val file_id: String,
    val file_unique_id: String,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
)
