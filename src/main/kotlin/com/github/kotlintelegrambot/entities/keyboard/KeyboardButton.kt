package com.github.kotlintelegrambot.entities.keyboard

import com.github.kotlintelegrambot.entities.polls.PollType

/**
 * Represents one button of the reply keyboard.
 * For simple text buttons String can be used instead of this object to specify text of the button.
 * Optional fields requestContact, requestLocation, and requestPoll are mutually exclusive.
 * https://core.telegram.org/bots/api#keyboardbutton
 */
data class KeyboardButton(
    val text: String,
    val request_contact: Boolean? = null,
    val request_location: Boolean? = null,
    val request_poll: KeyboardButtonPollType? = null,
    val web_app: WebAppInfo? = null,
)

/**
 * Represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.
 * https://core.telegram.org/bots/api#keyboardbuttonpolltype
 */
data class KeyboardButtonPollType(
    val type: PollType? = null,
)
