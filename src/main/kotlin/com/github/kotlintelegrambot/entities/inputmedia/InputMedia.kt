package com.github.kotlintelegrambot.entities.inputmedia

import com.github.kotlintelegrambot.entities.TelegramFile

/**
 * Represents the content of a media message to be sent.
 * https://core.telegram.org/bots/api#inputmedia
 */
sealed class InputMedia {
    abstract val type: String
    abstract val media: TelegramFile
    abstract val caption: String?
    @JsName("parse_mode")
    abstract val parseMode: String?
}

/**
 * Interface to mark all the media types that can be sent within a group of media for
 * operations like `sendMediaGroup`.
 */
interface GroupableMedia

class MediaGroup private constructor(val medias: Array<out GroupableMedia>) {
    init {
        if (!(2..10).contains(medias.size)) {
            throw IllegalArgumentException("media groups must include 2-10 items")
        }
    }

    companion object {
        fun from(vararg media: GroupableMedia): MediaGroup = MediaGroup(media)
    }
}

/**
 * Represents a photo to be sent. Can be sent as part of a group of media.
 * https://core.telegram.org/bots/api#inputmediaphoto
 */
data class InputMediaPhoto(
    override val media: TelegramFile,
    override val caption: String? = null,
    override val parseMode: String? = null,
) : InputMedia(), GroupableMedia {
    override val type: String = "photo"
}

/**
 * Represents a video to be sent. Can be sent as part of a group of media.
 * https://core.telegram.org/bots/api#inputmediavideo
 */
data class InputMediaVideo(
    override val media: TelegramFile,
    override val caption: String? = null,
    override val parseMode: String? = null,
    val thumb: TelegramFile.ByFile? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null,
    val supports_streaming: Boolean? = null,
) : InputMedia(), GroupableMedia {
    override val type: String = "video"
}

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 * https://core.telegram.org/bots/api#inputmediaanimation
 */
data class InputMediaAnimation(
    override val media: TelegramFile,
    override val caption: String? = null,
    override val parseMode: String? = null,
    val thumb: TelegramFile.ByFile? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null,
) : InputMedia() {
    override val type: String = "animation"
}

/**
 * Represents an audio file to be treated as music to be sent.
 * https://core.telegram.org/bots/api#inputmediaaudio
 */
data class InputMediaAudio(
    override val media: TelegramFile,
    override val caption: String? = null,
    override val parseMode: String? = null,
    val thumb: TelegramFile.ByFile? = null,
    val duration: Int? = null,
    val performer: String? = null,
    val title: String? = null,
) : InputMedia(), GroupableMedia {
    override val type: String = "audio"
}

/**
 * Represents a general file to be sent.
 * https://core.telegram.org/bots/api#inputmediadocument
 */
data class InputMediaDocument(
    override val media: TelegramFile,
    override val caption: String? = null,
    override val parseMode: String? = null,
    val thumb: TelegramFile.ByFile? = null,
    val disable_content_type_detection: Boolean? = null,
) : InputMedia(), GroupableMedia {
    override val type: String = "document"
}
