package com.github.kotlintelegrambot.entities


data class ForceReplyMarkup(
    val force_reply: Boolean = true,
    val selective: Boolean? = null,
) : ReplyMarkup
