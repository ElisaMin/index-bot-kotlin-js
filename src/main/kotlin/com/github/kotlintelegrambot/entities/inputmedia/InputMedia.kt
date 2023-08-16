package com.github.kotlintelegrambot.entities.inputmedia

import com.github.kotlintelegrambot.entities.TelegramFile
import com.google.gson.annotations.SerializedName

/**
 * Represents the content of a media message to be sent.
 * https://core.telegram.org/bots/api#inputmedia
 */
sealed class InputMedia {
    abstract val type: String
    abstract val media: TelegramFile
    abstract val caption: String?
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
    @SerializedName("media") override val media: TelegramFile,
    @SerializedName("caption") override val caption: String? = null,
    @SerializedName("parse_mode") override val parseMode: String? = null,
) : InputMedia(), GroupableMedia {
    @SerializedName("type")
    override val type: String = "photo"
}

/**
 * Represents a video to be sent. Can be sent as part of a group of media.
 * https://core.telegram.org/bots/api#inputmediavideo
 */
data class InputMediaVideo(
    @SerializedName("media") override val media: TelegramFile,
    @SerializedName("caption") override val caption: String? = null,
    @SerializedName("parse_mode") override val parseMode: String? = null,
    @SerializedName("thumb") val thumb: TelegramFile.ByFile? = null,
    @SerializedName("width") val width: Int? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("duration") val duration: Int? = null,
    @SerializedName("supports_streaming") val supportsStreaming: Boolean? = null,
) : InputMedia(), GroupableMedia {
    @SerializedName("type")
    override val type: String = "video"
}

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 * https://core.telegram.org/bots/api#inputmediaanimation
 */
data class InputMediaAnimation(
    @SerializedName("media") override val media: TelegramFile,
    @SerializedName("caption") override val caption: String? = null,
    @SerializedName("parse_mode") override val parseMode: String? = null,
    @SerializedName("thumb") val thumb: TelegramFile.ByFile? = null,
    @SerializedName("width") val width: Int? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("duration") val duration: Int? = null,
) : InputMedia() {
    @SerializedName("type")
    override val type: String = "animation"
}

/**
 * Represents an audio file to be treated as music to be sent.
 * https://core.telegram.org/bots/api#inputmediaaudio
 */
data class InputMediaAudio(
    @SerializedName("media") override val media: TelegramFile,
    @SerializedName("caption") override val caption: String? = null,
    @SerializedName("parse_mode") override val parseMode: String? = null,
    @SerializedName("thumb") val thumb: TelegramFile.ByFile? = null,
    @SerializedName("duration") val duration: Int? = null,
    @SerializedName("performer") val performer: String? = null,
    @SerializedName("title") val title: String? = null,
) : InputMedia(), GroupableMedia {
    @SerializedName("type")
    override val type: String = "audio"
}

/**
 * Represents a general file to be sent.
 * https://core.telegram.org/bots/api#inputmediadocument
 */
data class InputMediaDocument(
    @SerializedName("media") override val media: TelegramFile,
    @SerializedName("caption") override val caption: String? = null,
    @SerializedName("parse_mode") override val parseMode: String? = null,
    @SerializedName("thumb") val thumb: TelegramFile.ByFile? = null,
    @SerializedName("disable_content_type_detection") val disableContentTypeDetection: Boolean? = null,
) : InputMedia(), GroupableMedia {
    @SerializedName("type")
    override val type: String = "document"
}
