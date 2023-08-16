package com.github.kotlintelegrambot.entities.files

/**
 * Represents a file ready to be downloaded. The file can be downloaded via the link
 * https://api.telegram.org/file/bot<token>/<file_path>. It is guaranteed that the
 * link will be valid for at least 1 hour. When the link expires, a new one can be
 * requested by calling getFile.
 * https://core.telegram.org/bots/api#file
 */
data class File(
    val file_id: String,
    val file_unique_id: String,
    val file_size: Int? = null,
    val file_path: String? = null,
)
