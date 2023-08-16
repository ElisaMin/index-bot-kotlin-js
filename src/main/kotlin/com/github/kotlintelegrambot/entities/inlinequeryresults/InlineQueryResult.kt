package com.github.kotlintelegrambot.entities.inlinequeryresults

import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.ParseMode
import com.google.gson.annotations.SerializedName

enum class MimeType(val rawName: String) {
    @SerializedName("text/html")
    TEXT_HTML("text/html"),

    @SerializedName("video/mp4")
    VIDEO_MP4("video/mp4"),

    @SerializedName("application/pdf")
    APPLICATION_PDF("application/pdf"),

    @SerializedName("application/zip")
    APPLICATION_ZIP("application/zip"),

    @SerializedName("image/jpeg")
    IMAGE_JPEG("image/jpeg"),

    @SerializedName("image/gif")
    IMAGE_GIF("image/gif"),
}

fun String.toMimeType(): MimeType? =
    MimeType.entries.firstOrNull { type -> this == type.rawName }

private object QueryResultTypes {
    const val ARTICLE = "article"
    const val PHOTO = "photo"
    const val VIDEO = "video"
    const val VOICE = "voice"
    const val STICKER = "sticker"
    const val MPEG4_GIF = "mpeg4_gif"
    const val GIF = "gif"
    const val AUDIO = "audio"
    const val DOCUMENT = "document"
    const val LOCATION = "location"
    const val VENUE = "venue"
    const val CONTACT = "contact"
    const val GAME = "game"
}

sealed class InlineQueryResult(
    val type: String,
) {
    abstract val id: String
    abstract val replyMarkup: InlineKeyboardMarkup?

    data class Article(
        override val id: String,
        val title: String,
        val input_message_content: InputMessageContent,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val url: String? = null,
        val hide_url: Boolean? = null,
        val description: String? = null,
        val thumb_url: String? = null,
        val thumb_width: Int? = null,
        val thumb_height: Int? = null,
    ) : InlineQueryResult(QueryResultTypes.ARTICLE)

    data class Photo(
        override val id: String,
        val photo_url: String,
        val thumb_url: String,
        val photo_width: Int? = null,
        val photo_height: Int? = null,
        val title: String? = null,
        val description: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.PHOTO)

    data class Gif(
        override val id: String,
        val gif_url: String,
        val gif_width: Int? = null,
        val gif_height: Int? = null,
        val gif_duration: Int? = null,
        val thumb_url: String,
        val thumb_mime_type: MimeType? = null,
        val title: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.GIF)

    data class Mpeg4Gif(
        override val id: String,
        @SerializedName("mpeg4_url") val mpeg4Url: String,
        @SerializedName("mpeg4_width") val mpeg4Width: Int? = null,
        @SerializedName("mpeg4_height") val mpeg4Height: Int? = null,
        @SerializedName("mpeg4_duration") val mpeg4Duration: Int? = null,
        val thumb_url: String,
        val thumb_mime_type: MimeType? = null,
        val title: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.MPEG4_GIF)

    data class Video(
        override val id: String,
        val video_url: String,
        val mime_type: MimeType,
        val thumb_url: String,
        val title: String,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        val video_width: Int? = null,
        val video_height: Int? = null,
        val video_duration: Int? = null,
        val description: String? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.VIDEO)

    data class Audio(
        override val id: String,
        val audio_url: String,
        val title: String,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        val performer: String? = null,
        val audio_duration: Int? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.AUDIO)

    data class Voice(
        override val id: String,
        val voice_url: String,
        val title: String,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        val voice_duration: Int? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.VOICE)

    data class Document(
        override val id: String,
        val title: String,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        val document_url: String,
        val mime_type: MimeType,
        val description: String? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
        val thumb_url: String? = null,
        val thumb_width: Int? = null,
        val thumb_height: Int? = null,
    ) : InlineQueryResult(QueryResultTypes.DOCUMENT)

    data class Location(
        override val id: String,
        val latitude: Float,
        val longitude: Float,
        val title: String,
        val live_period: Int? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
        val thumb_url: String? = null,
        val thumb_width: Int? = null,
        val thumb_height: Int? = null,
        val proximity_alert_radius: Int? = null,
    ) : InlineQueryResult(QueryResultTypes.LOCATION)

    data class Venue(
        override val id: String,
        val latitude: Float,
        val longitude: Float,
        val title: String,
        val address: String,
        val foursquare_id: String? = null,
        val foursquare_type: String? = null,
        val google_place_id: String? = null,
        val google_place_type: String? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
        val thumb_url: String? = null,
        val thumb_width: Int? = null,
        val thumb_height: Int? = null,
    ) : InlineQueryResult(QueryResultTypes.VENUE)

    data class Contact(
        override val id: String,
        val phone_number: String,
        val first_name: String,
        val last_name: String? = null,
        val vcard: String? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
        val thumb_url: String? = null,
        val thumb_width: Int? = null,
        val thumb_height: Int? = null,
    ) : InlineQueryResult(QueryResultTypes.CONTACT)

    data class Game(
        override val id: String,
        val game_short_name: String,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
    ) : InlineQueryResult(QueryResultTypes.GAME)

    data class CachedAudio(
        override val id: String,
        val audio_file_id: String,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.AUDIO)

    data class CachedDocument(
        override val id: String,
        val title: String,
        val document_file_id: String,
        val description: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.DOCUMENT)

    data class CachedGif(
        override val id: String,
        val gif_file_id: String,
        val title: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.GIF)

    data class CachedMpeg4Gif(
        override val id: String,
        @SerializedName("mpeg4_file_id") val mpeg4FileId: String,
        val title: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.MPEG4_GIF)

    data class CachedPhoto(
        override val id: String,
        val photo_file_id: String,
        val title: String? = null,
        val description: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.PHOTO)

    data class CachedSticker(
        override val id: String,
        val sticker_file_id: String,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.STICKER)

    data class CachedVideo(
        override val id: String,
        val video_file_id: String,
        val title: String,
        val description: String? = null,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.VIDEO)

    data class CachedVoice(
        override val id: String,
        val voice_file_id: String,
        val title: String,
        val caption: String? = null,
        val parse_mode: ParseMode? = null,
        @SerializedName("reply_markup") override val replyMarkup: InlineKeyboardMarkup? = null,
        val input_message_content: InputMessageContent? = null,
    ) : InlineQueryResult(QueryResultTypes.VOICE)
}
