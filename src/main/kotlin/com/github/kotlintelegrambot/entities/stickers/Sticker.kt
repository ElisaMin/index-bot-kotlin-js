package com.github.kotlintelegrambot.entities.stickers

import com.github.kotlintelegrambot.entities.files.PhotoSize

/**
 * Represents a sticker.
 * https://core.telegram.org/bots/api#sticker
 */
data class Sticker(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val is_animated: Boolean,
    val thumb: PhotoSize? = null,
    val emoji: String?,
    @JsName("set_name") val setName: String? = null,
    val mask_position: MaskPosition? = null,
    val file_size: Int? = null,
)
