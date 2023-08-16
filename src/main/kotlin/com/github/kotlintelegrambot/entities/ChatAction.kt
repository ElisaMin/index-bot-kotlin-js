package com.github.kotlintelegrambot.entities


enum class ChatAction {
    @JsName("typing")
    TYPING,

    @JsName("upload_photo")
    UPLOAD_PHOTO,

    @JsName("record_video")
    RECORD_VIDEO,

    @JsName("upload_video")
    UPLOAD_VIDEO,

    @JsName("record_audio")
    RECORD_AUDIO,

    @JsName("upload_audio")
    UPLOAD_AUDIO,

    @JsName("upload_document")
    UPLOAD_DOCUMENT,

    @JsName("find_location")
    FIND_LOCATION,

    @JsName("record_video_note")
    RECORD_VIDEO_NOTE,

    @JsName("upload_video_note")
    UPLOAD_VIDEO_NOTE,

    @JsName("choose_sticker")
    CHOOSE_STICKER,
}
