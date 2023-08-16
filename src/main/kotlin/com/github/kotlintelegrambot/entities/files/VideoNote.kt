package com.github.kotlintelegrambot.entities.files

/**
 * Represents a video message (available in Telegram apps as of v.4.0).
 * https://core.telegram.org/bots/api#videonote
 */
data class VideoNote(
    val file_id: String,
    val file_unique_id: String,
    val length: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val file_size: Int? = null,
)
