package com.github.kotlintelegrambot.entities

data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null,
    val google_place_id: String? = null,
    val google_place_type: String? = null,
)
