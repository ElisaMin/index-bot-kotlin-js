package com.github.kotlintelegrambot.entities.inlinequeryresults

import com.github.kotlintelegrambot.entities.ParseMode

sealed class InputMessageContent {
    data class Text(
        val message_text: String,
        val parse_mode: ParseMode? = null,
        val disable_web_page_preview: Boolean? = null,
    ) : InputMessageContent()

    data class Location(
        val latitude: Float,
        val longitude: Float,
        val live_period: Int? = null,
        val proximity_alert_radius: Int? = null,
    ) : InputMessageContent()

    data class Venue(
        val latitude: Float,
        val longitude: Float,
        val title: String,
        val address: String,
        val foursquare_id: String? = null,
        val foursquare_type: String? = null,
        val google_place_id: String? = null,
        val google_place_type: String? = null,
    ) : InputMessageContent()

    data class Contact(
        val phone_number: String,
        val first_name: String,
        val last_name: String? = null,
        val vcard: String? = null,
    )
}
