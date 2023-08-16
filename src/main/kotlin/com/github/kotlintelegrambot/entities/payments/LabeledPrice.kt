package com.github.kotlintelegrambot.entities.payments


data class LabeledPrice(
    val label: String? = null,
    val amount: Long,
)
