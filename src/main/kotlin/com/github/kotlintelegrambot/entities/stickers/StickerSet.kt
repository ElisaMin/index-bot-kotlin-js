package com.github.kotlintelegrambot.entities.stickers

import com.github.kotlintelegrambot.entities.files.PhotoSize

data class StickerSet(
    val name: String,
    val title: String,
    val is_animated: Boolean,
    val contains_masks: Boolean,
    val stickers: List<Sticker>,
    val thumb: PhotoSize?,
)
