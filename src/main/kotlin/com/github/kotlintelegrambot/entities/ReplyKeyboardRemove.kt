package com.github.kotlintelegrambot.entities


class ReplyKeyboardRemove(
    val remove_keyboard: Boolean = true,
    val selective: Boolean? = null,
) : ReplyMarkup