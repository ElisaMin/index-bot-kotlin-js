package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.files.ChatPhoto

/**
 * Represents a chat.
 * https://core.telegram.org/bots/api#chat
 */
data class Chat(
    val id: Long,
    val type: String,
    val title: String? = null,
    val username: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val photo: ChatPhoto? = null,
    val bio: String? = null,
    val description: String? = null,
    val invite_link: String? = null,
    val pinned_message: String? = null,
    val permissions: ChatPermissions? = null,
    val slow_mode_delay: Int? = null,
    val sticker_set_name: String? = null,
    val can_set_sticker_set: Boolean? = null,
    val linked_chat_id: Long? = null,
    val location: ChatLocation? = null,
)
