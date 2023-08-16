package com.github.kotlintelegrambot.entities

/**
 * Represents a Telegram user or bot.
 */
data class User(
    val id: Long,
    val is_bot: Boolean,
    val first_name: String,
    val last_name: String? = null,
    val username: String? = null,
    val language_code: String? = null,
    val can_join_groups: Boolean? = null,
    val can_read_all_group_messages: Boolean? = null,
    val supports_inline_queries: Boolean? = null,
)
