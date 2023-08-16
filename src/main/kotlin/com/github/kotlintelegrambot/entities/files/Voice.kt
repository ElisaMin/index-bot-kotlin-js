package com.github.kotlintelegrambot.entities.files

/**
 * Represents a voice note.
 * https://core.telegram.org/bots/api#voice
 */
data class Voice(
    val file_id: String,
    val file_unique_id: String,
    val duration: Int,
    val mime_type: String? = null,
    val file_size: Int? = null,
)
