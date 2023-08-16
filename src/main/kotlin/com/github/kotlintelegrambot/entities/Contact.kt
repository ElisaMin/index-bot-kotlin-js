package com.github.kotlintelegrambot.entities

data class Contact(
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val user_id: Long? = null,
)
