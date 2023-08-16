package com.github.kotlintelegrambot.entities.files

import com.google.gson.annotations.SerializedName

/**
 * Represents a file ready to be downloaded. The file can be downloaded via the link
 * https://api.telegram.org/file/bot<token>/<file_path>. It is guaranteed that the
 * link will be valid for at least 1 hour. When the link expires, a new one can be
 * requested by calling getFile.
 * https://core.telegram.org/bots/api#file
 */
data class File(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("file_size") val fileSize: Int? = null,
    @SerializedName("file_path") val filePath: String? = null,
)
