package com.github.kotlintelegrambot.entities


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
        @JsName("mention")
        MENTION,

        @JsName("hashtag")
        HASHTAG,

        @JsName("cashtag")
        CASHTAG,

        @JsName("bot_command")
        BOT_COMMAND,

        @JsName("url")
        URL,

        @JsName("email")
        EMAIL,

        @JsName("phone_number")
        PHONE_NUMBER,

        @JsName("bold")
        BOLD,

        @JsName("italic")
        ITALIC,

        @JsName("underline")
        UNDERLINE,

        @JsName("strikethrough")
        STRIKETHROUGH,

        @JsName("code")
        CODE,

        @JsName("pre")
        PRE,

        @JsName("text_link")
        TEXT_LINK,

        @JsName("text_mention")
        TEXT_MENTION,

        @JsName("spoiler")
        SPOILER,
    }
}
