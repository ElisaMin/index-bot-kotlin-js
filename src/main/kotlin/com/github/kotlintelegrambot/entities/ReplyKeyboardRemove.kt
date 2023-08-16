package com.github.kotlintelegrambot.entities


import com.google.gson.annotations.SerializedName

class ReplyKeyboardRemove constructor(
    val remove_keyboard: Boolean = true,
    val selective: Boolean? = null,
) : ReplyMarkup