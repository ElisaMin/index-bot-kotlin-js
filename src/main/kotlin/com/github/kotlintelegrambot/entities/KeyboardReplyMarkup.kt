package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.keyboard.KeyboardButton

data class KeyboardReplyMarkup(
    val keyboard: List<List<KeyboardButton>>,
    val resize_keyboard: Boolean = false,
    val one_time_keyboard: Boolean = false,
    val selective: Boolean? = null,
) : ReplyMarkup {

    constructor(
        vararg keyboard: KeyboardButton,
        resizeKeyboard: Boolean = false,
        oneTimeKeyboard: Boolean = false,
        selective: Boolean? = null,
    ) : this(listOf(keyboard.toList()), resizeKeyboard, oneTimeKeyboard, selective)

    companion object {

        fun createSimpleKeyboard(
            keyboard: List<List<String>>,
            resizeKeyboard: Boolean = true,
            oneTimeKeyboard: Boolean = false,
            selective: Boolean? = null,
        ): KeyboardReplyMarkup {
            return KeyboardReplyMarkup(keyboard.map { it.map { KeyboardButton(text = it) } }, resizeKeyboard, oneTimeKeyboard, selective)
        }
    }
}
