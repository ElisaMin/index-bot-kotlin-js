package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.payments.PreCheckoutQuery
import com.github.kotlintelegrambot.entities.payments.ShippingQuery
import com.github.kotlintelegrambot.entities.polls.Poll
import com.github.kotlintelegrambot.entities.polls.PollAnswer
import com.github.kotlintelegrambot.types.ConsumableObject
import com.github.kotlintelegrambot.types.DispatchableObject

data class Update constructor(
    val update_id: Long,
    val message: Message? = null,
    val edited_message: Message? = null,
    val channel_post: Message? = null,
    val edited_channel_post: Message? = null,
    val inline_query: InlineQuery? = null,
    val chosen_inline_result: ChosenInlineResult? = null,
    val callback_query: CallbackQuery? = null,
    val shipping_query: ShippingQuery? = null,
    val pre_checkout_query: PreCheckoutQuery? = null,
    val poll: Poll? = null,
    val poll_answer: PollAnswer? = null,
) : DispatchableObject, ConsumableObject()

/**
 * Generate list of key-value from start payload.
 * For more info {@link https://core.telegram.org/bots#deep-linking}
 */
fun Update.getStartPayload(delimiter: String = "-"): List<Pair<String, String>> {
    return message?.let {
        val parameters = it.text?.substringAfter("start ", "")
        if (parameters == null || parameters.isEmpty()) {
            return emptyList()
        }

        val split = parameters.split("&")
        split.map {
            val keyValue = it.split(delimiter)
            Pair(keyValue[0], keyValue[1])
        }
    } ?: emptyList()
}
