package com.github.kotlintelegrambot.entities

data class Location(
    val longitude: Float,
    val latitude: Float,
    val live_period: Int? = null,
    val proximity_alert_radius: Int? = null,
)
