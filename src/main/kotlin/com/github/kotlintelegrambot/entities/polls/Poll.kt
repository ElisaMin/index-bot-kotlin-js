package com.github.kotlintelegrambot.entities.polls

import com.github.kotlintelegrambot.entities.MessageEntity

/**
 * Contains information about a poll.
 * https://core.telegram.org/bots/api#poll
 */
data class Poll(
    val id: Long,
    val question: String,
    val options: List<PollOption>,
    val total_voter_count: Int,
    val is_closed: Boolean,
    val is_anonymous: Boolean,
    val type: PollType,
    val allows_multiple_answers: Boolean,
    val correct_option_id: Int? = null,
    val explanation: String? = null,
    val explanation_entities: List<MessageEntity>? = null,
    val open_period: Int? = null,
    val close_date: Long? = null,
)
