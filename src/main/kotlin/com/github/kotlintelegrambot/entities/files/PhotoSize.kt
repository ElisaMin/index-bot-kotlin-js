package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents one size of a photo or a file / sticker thumbnail.
 * https://core.telegram.org/bots/api#photosize
 */
data class PhotoSize(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("file_size") val fileSize: Int? = null,
)
