package com.github.kotlintelegrambot.entities.keyboard

import com.github.kotlintelegrambot.entities.polls.PollType
import com.google.gson.annotations.SerializedName

/**
 * Represents one button of the reply keyboard.
 * For simple text buttons String can be used instead of this object to specify text of the button.
 * Optional fields requestContact, requestLocation, and requestPoll are mutually exclusive.
 * https://core.telegram.org/bots/api#keyboardbutton
 */
data class KeyboardButton(
    @SerializedName("text") val text: String,
    @SerializedName("request_contact") val requestContact: Boolean? = null,
    @SerializedName("request_location") val requestLocation: Boolean? = null,
    @SerializedName("request_poll") val requestPoll: KeyboardButtonPollType? = null,
    @SerializedName("web_app") val webApp: WebAppInfo? = null,
)

/**
 * Represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.
 * https://core.telegram.org/bots/api#keyboardbuttonpolltype
 */
data class KeyboardButtonPollType(
    @SerializedName("type") val type: PollType? = null,
)
