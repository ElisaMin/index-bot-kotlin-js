package com.github.kotlintelegrambot.entities.stickers

import com.github.kotlintelegrambot.entities.files.PhotoSize
import com.google.gson.annotations.SerializedName

/**
 * Represents a sticker.
 * https://core.telegram.org/bots/api#sticker
 */
data class Sticker(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("is_animated") val isAnimated: Boolean,
    @SerializedName("thumb") val thumb: PhotoSize? = null,
    @SerializedName("emoji") val emoji: String?,
    @SerializedName("set_name")val setName: String? = null,
    @SerializedName("mask_position") val maskPosition: MaskPosition? = null,
    @SerializedName("file_size") val fileSize: Int? = null,
)
