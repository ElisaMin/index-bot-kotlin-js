package com.github.kotlintelegrambot.entities.polls

/**
 * Contains information about one answer option in a poll.
 * https://core.telegram.org/bots/api#polloption
 */
data class PollOption(
    val text: String,
    val voter_count: Int,
)
