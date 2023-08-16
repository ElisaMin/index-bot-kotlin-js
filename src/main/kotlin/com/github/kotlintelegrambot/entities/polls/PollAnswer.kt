package com.github.kotlintelegrambot.entities.polls

import com.github.kotlintelegrambot.entities.User
import com.google.gson.annotations.SerializedName

/**
 * Represents an answer of a user in a non-anonymous poll.
 * https://core.telegram.org/bots/api#poll_answer
 */
data class PollAnswer(
    @SerializedName("poll_id") val pollId: String,
    @SerializedName("user") val user: User,
    @SerializedName("option_ids") val optionIds: List<Int>,
)
