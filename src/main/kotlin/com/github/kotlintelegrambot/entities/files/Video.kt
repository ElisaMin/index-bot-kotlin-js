package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents a video file.
 * https://core.telegram.org/bots/api#video
 */
data class Video(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("duration") val duration: Int,
    @SerializedName("thumb") val thumb: PhotoSize? = null,
    @SerializedName("mime_type") val mimeType: String? = null,
    @SerializedName("file_size") val fileSize: Int? = null,
    @SerializedName("file_name") val fileName: String? = null,
)
