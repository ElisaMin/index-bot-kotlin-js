package com.github.kotlintelegrambot.entities.polls

import com.github.kotlintelegrambot.entities.User

/**
 * Represents an answer of a user in a non-anonymous poll.
 * https://core.telegram.org/bots/api#poll_answer
 */
data class PollAnswer(
    val poll_id: String,
    val user: User,
    val option_ids: List<Int>,
)
