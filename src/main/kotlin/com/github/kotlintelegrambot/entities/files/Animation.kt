package com.github.kotlintelegrambot.entities.files

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 * https://core.telegram.org/bots/api#animation
 */
data class Animation(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Long? = null,
)
