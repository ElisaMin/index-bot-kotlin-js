package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.files.Animation
import com.github.kotlintelegrambot.entities.files.PhotoSize

data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String? = null,
    val text_entities: List<MessageEntity>? = null,
    val animation: Animation? = null,
)
