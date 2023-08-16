package com.github.kotlintelegrambot.entities.files

/**
 * Represents one size of a photo or a file / sticker thumbnail.
 * https://core.telegram.org/bots/api#photosize
 */
data class PhotoSize(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val file_size: Int? = null,
)
