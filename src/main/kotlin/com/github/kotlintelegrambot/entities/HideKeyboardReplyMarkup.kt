package com.github.kotlintelegrambot.entities


data class HideKeyboardReplyMarkup(
    val hide_keyboard: Boolean = true,
    val selective: Boolean? = null,
) : ReplyMarkup