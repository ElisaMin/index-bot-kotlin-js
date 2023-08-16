package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents a chat photo.
 * https://core.telegram.org/bots/api#chatphoto
 */
data class ChatPhoto(
    @SerializedName("small_file_id") val smallFileId: String,
    @SerializedName("small_file_unique_id") val smallFileUniqueId: String,
    @SerializedName("big_file_id") val bigFileId: String,
    @SerializedName("big_file_unique_id") val bigFileUniqueId: String,
)
