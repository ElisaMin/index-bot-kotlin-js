package com.github.kotlintelegrambot.entities.polls

import com.github.kotlintelegrambot.entities.MessageEntity
import com.google.gson.annotations.SerializedName

/**
 * Contains information about a poll.
 * https://core.telegram.org/bots/api#poll
 */
data class Poll(
    @SerializedName("id") val id: Long,
    @SerializedName("question") val question: String,
    @SerializedName("options") val options: List<PollOption>,
    @SerializedName("total_voter_count") val totalVoterCount: Int,
    @SerializedName("is_closed") val isClosed: Boolean,
    @SerializedName("is_anonymous") val isAnonymous: Boolean,
    @SerializedName("type") val type: PollType,
    @SerializedName("allows_multiple_answers") val allowsMultipleAnswers: Boolean,
    @SerializedName("correct_option_id") val correctOptionId: Int? = null,
    @SerializedName("explanation") val explanation: String? = null,
    @SerializedName("explanation_entities") val explanationEntities: List<MessageEntity>? = null,
    @SerializedName("open_period") val openPeriod: Int? = null,
    @SerializedName("close_date") val closeData: Long? = null,
)
