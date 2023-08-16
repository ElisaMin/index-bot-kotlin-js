package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 * https://core.telegram.org/bots/api#animation
 */
data class Animation(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("duration") val duration: Int,
    @SerializedName("thumb") val thumb: PhotoSize? = null,
    @SerializedName("file_name") val fileName: String? = null,
    @SerializedName("mime_type") val mimeType: String? = null,
    @SerializedName("file_size") val fileSize: Long? = null,
)
