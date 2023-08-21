package com.github.kotlintelegrambot.entities

value class ChatAction private constructor(val action: String) {
    companion object {
        val TYPING = ChatAction("typing")
        val UPLOAD_PHOTO = ChatAction("upload_photo")
        val RECORD_VIDEO = ChatAction("record_video")
        val UPLOAD_VIDEO = ChatAction("upload_video")
        val RECORD_AUDIO = ChatAction("record_audio")
        val UPLOAD_AUDIO = ChatAction("upload_audio")
        val UPLOAD_DOCUMENT = ChatAction("upload_document")
        val FIND_LOCATION = ChatAction("find_location")
        val RECORD_VIDEO_NOTE = ChatAction("record_video_note")
        val UPLOAD_VIDEO_NOTE = ChatAction("upload_video_note")
        val CHOOSE_STICKER = ChatAction("choose_sticker")
    }

    override fun toString(): String {
        return action
    }
}
//enum class ChatAction {
//    @JsName("typing")
//    TYPING,
//
//    @JsName("upload_photo")
//    UPLOAD_PHOTO,
//
//    @JsName("record_video")
//    RECORD_VIDEO,
//
//    @JsName("upload_video")
//    UPLOAD_VIDEO,
//
//    @JsName("record_audio")
//    RECORD_AUDIO,
//
//    @JsName("upload_audio")
//    UPLOAD_AUDIO,
//
//    @JsName("upload_document")
//    UPLOAD_DOCUMENT,
//
//    @JsName("find_location")
//    FIND_LOCATION,
//
//    @JsName("record_video_note")
//    RECORD_VIDEO_NOTE,
//
//    @JsName("upload_video_note")
//    UPLOAD_VIDEO_NOTE,
//
//    @JsName("choose_sticker")
//    CHOOSE_STICKER,
//}
