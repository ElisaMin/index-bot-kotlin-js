package com.github.kotlintelegrambot.entities

data class Invoice(
    val title: String,
    val description: String,
    val start_parameter: String,
    val currency: String,
    val total_amount: Int,
)
