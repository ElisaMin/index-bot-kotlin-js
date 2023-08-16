package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents a video message (available in Telegram apps as of v.4.0).
 * https://core.telegram.org/bots/api#videonote
 */
data class VideoNote(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("length") val length: Int,
    @SerializedName("duration") val duration: Int,
    @SerializedName("thumb") val thumb: PhotoSize? = null,
    @SerializedName("file_size") val fileSize: Int? = null,
)
