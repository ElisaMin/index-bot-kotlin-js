package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents a general file (as opposed to photos, voice messages and audio files).
 * https://core.telegram.org/bots/api#document
 */
data class Document(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("thumb") val thumb: PhotoSize? = null,
    @SerializedName("file_name") val fileName: String? = null,
    @SerializedName("mime_type") val mimeType: String? = null,
    @SerializedName("file_size") val fileSize: Int? = null,
)
