package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents an audio file to be treated as music by the Telegram clients.
 * https://core.telegram.org/bots/api#audio
 */
data class Audio(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("performer") val performer: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("mime_type") val mimeType: String? = null,
    @SerializedName("file_size") val fileSize: Int? = null,
    @SerializedName("thumb") val thumb: PhotoSize? = null,
    @SerializedName("file_name") val fileName: String? = null,
)
