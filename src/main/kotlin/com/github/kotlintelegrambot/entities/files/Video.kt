package com.github.kotlintelegrambot.entities.files

/**
 * Represents a video file.
 * https://core.telegram.org/bots/api#video
 */
data class Video(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
    val file_name: String? = null,
)
