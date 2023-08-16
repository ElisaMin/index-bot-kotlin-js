package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.files.PhotoSize

data class UserProfilePhotos(
    val total_count: Int,
    val photos: List<List<PhotoSize>>,
)
