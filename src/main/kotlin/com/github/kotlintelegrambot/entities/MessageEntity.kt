package com.github.kotlintelegrambot.entities

import com.google.gson.annotations.SerializedName

/**
 * Represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 */
data class MessageEntity(
    val type: Type,
    val offset: Int,
    val length: Int,
    val url: String? = null,
    val user: User? = null,
    val language: String? = null,
) {
    enum class Type {
        @SerializedName("mention")
        MENTION,

        @SerializedName("hashtag")
        HASHTAG,

        @SerializedName("cashtag")
        CASHTAG,

        @SerializedName("bot_command")
        BOT_COMMAND,

        @SerializedName("url")
        URL,

        @SerializedName("email")
        EMAIL,

        @SerializedName("phone_number")
        PHONE_NUMBER,

        @SerializedName("bold")
        BOLD,

        @SerializedName("italic")
        ITALIC,

        @SerializedName("underline")
        UNDERLINE,

        @SerializedName("strikethrough")
        STRIKETHROUGH,

        @SerializedName("code")
        CODE,

        @SerializedName("pre")
        PRE,

        @SerializedName("text_link")
        TEXT_LINK,

        @SerializedName("text_mention")
        TEXT_MENTION,

        @SerializedName("spoiler")
        SPOILER,
    }
}
