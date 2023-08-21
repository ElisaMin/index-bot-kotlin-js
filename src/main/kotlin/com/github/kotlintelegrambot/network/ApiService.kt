@file:Suppress("unused", "PropertyName", "LocalVariableName", "NOTHING_TO_INLINE")

package com.github.kotlintelegrambot.network

import com.github.kotlintelegrambot.entities.*
import com.github.kotlintelegrambot.entities.inputmedia.InputMedia
import com.github.kotlintelegrambot.entities.payments.ShippingOption
import com.github.kotlintelegrambot.entities.polls.Poll
import com.github.kotlintelegrambot.entities.stickers.MaskPosition
import com.github.kotlintelegrambot.entities.stickers.StickerSet

interface Response<T> {
    val ok: Boolean
    val result: T
    val description: String?
}
interface Call<T> {
}
val jsObj get() = js("{}")

@GET("getUpdates")
interface GetUpdates : Call<Response<List<Update>>> {
    var offset: Long?
    var limit: Int?
    var timeout: Int?
    var allowed_updates: Array<String>?
     companion object {
         inline operator fun invoke(
             offset: Long? = null,
             limit: Int? = null,
             timeout: Int? = null,
             allowed_updates: Array<String>? = null
         ) = with(jsObj) {
             this.offset = offset
             this.limit = limit
             this.timeout = timeout
             this.allowed_updates = allowed_updates
             this.unsafeCast<GetUpdates>()
         }
     }
}

//@FormUrlEncoded
//@POST("setWebhook")
//interface SetWebhook : Call<Response<Boolean>> {
//    var url: String
//    var ip_address: String?
//    var max_connections: Int?
//    var allowed_updates: List<String>?
//    var drop_pending_updates: Boolean?
//    companion object {
//        inline operator fun invoke(
//            url: String,
//            ip_address: String? = null,
//            max_connections: Int? = null,
//            allowed_updates: List<String>? = null,
//            drop_pending_updates: Boolean? = null
//        ) = with(jsObj) {
//            this.url = url
//            this.ip_address = ip_address
//            this.max_connections = max_connections
//            this.allowed_updates = allowed_updates
//            this.drop_pending_updates = drop_pending_updates
//            this.unsafeCast<SetWebhook>()
//        }
//    }
//}

//
//@FormUrlEncoded
//@POST("setWebhook")
//interface SetWebhookWithCertificateAsFileId : Call<Response<Boolean>> {
//
//    var url: String
//    var certificateFileId: String
//    var ip_address: String?
//    var max_connections: Int?
//    var allowed_updates: List<String>?
//    var drop_pending_updates: Boolean?
//    
//    companion object {
//        inline operator fun invoke(
//            url: String,
//            certificateFileId: String,
//            ip_address: String? = null,
//            max_connections: Int? = null,
//            allowed_updates: List<String>? = null,
//            drop_pending_updates: Boolean? = null
//        ) = with(jsObj) {
//            this.url = url
//            this.certificateFileId = certificateFileId
//            this.ip_address = ip_address
//            this.max_connections = max_connections
//            this.allowed_updates = allowed_updates
//            this.drop_pending_updates = drop_pending_updates
//            this.unsafeCast<SetWebhookWithCertificateAsFileId>()
//        }
//    }
//}
//
////
//@FormUrlEncoded
//@POST("setWebhook")
//interface SetWebhookWithCertificateAsFileUrl : Call<Response<Boolean>> {
//
//    var url: String
//    var certificateUrl: String
//    var ip_address: String?
//    var max_connections: Int?
//    var allowed_updates: List<String>?
//    var drop_pending_updates: Boolean?
//    companion object {
//        inline operator fun invoke(
//            url: String,
//            certificateUrl: String,
//            ip_address: String? = null,
//            max_connections: Int? = null,
//            allowed_updates: List<String>? = null,
//            drop_pending_updates: Boolean? = null
//        ) = with(jsObj) {
//            this.url = url
//            this.certificateUrl = certificateUrl
//            this.ip_address = ip_address
//            this.max_connections = max_connections
//            this.allowed_updates = allowed_updates
//            this.drop_pending_updates = drop_pending_updates
//            this.unsafeCast<SetWebhookWithCertificateAsFileUrl>()
//        }
//}
//
//@Multipart
//@POST("setWebhook")
//interface SetWebhookWithCertificateAsFile : Call<Response<Boolean>> {
//
//    @JsName url: MultipartBody.Part
//    @JsName certificate: MultipartBody.Part
//    @JsName ipAddress: MultipartBody.Part?
//    @JsName maxConnections: MultipartBody.Part?
//    @JsName allowedUpdates: MultipartBody.Part?
//    @JsName dropPendingUpdates: MultipartBody.Part?
//}

//@GET("deleteWebhook")
//interface DeleteWebhook : Call<Response<Boolean>> {
//    var drop_pending_updates: Boolean?
//    companion object {
//        inline operator fun invoke(
//            drop_pending_updates: Boolean? = null
//        ) = with(jsObj) {
//            this.drop_pending_updates = drop_pending_updates
//            this.unsafeCast<DeleteWebhook>()
//        }
//    }
//}
//
//@GET("getWebhookInfo")
//class GetWebhookInfo : Call<Response<WebhookInfo>>

/**
 * Available methods
 */

@GET("getMe")
class GetMe : Call<Response<User>>

@FormUrlEncoded
@POST("sendMessage")
interface SendMessage : Call<Response<Message>> {

    var chat_id: ChatId
    var text: String
    var parse_mode: ParseMode?
    var disable_web_page_preview: Boolean?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            text: String,
            parse_mode: ParseMode? = null,
            disable_web_page_preview: Boolean? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.text = text
            this.parse_mode = parse_mode
            this.disable_web_page_preview = disable_web_page_preview
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendMessage>()
        }
    }
}

@FormUrlEncoded
@POST("forwardMessage")
interface ForwardMessage : Call<Response<Message>> {

    var chat_id: ChatId
    var from_chat_id: ChatId
    var disable_notification: Boolean?
    var message_id: Long
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            from_chat_id: ChatId,
            disable_notification: Boolean? = null,
            message_id: Long
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.from_chat_id = from_chat_id
            this.disable_notification = disable_notification
            this.message_id = message_id
            this.unsafeCast<ForwardMessage>()
        }
    }
}

@FormUrlEncoded
@POST("copyMessage")
interface CopyMessage : Call<Response<MessageId>> {

    var chat_id: ChatId
    var from_chat_id: ChatId
    var message_id: Long
    var caption: String?
    var parse_mode: ParseMode?
    var caption_entities: String?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            from_chat_id: ChatId,
            message_id: Long,
            caption: String? = null,
            parse_mode: ParseMode? = null,
            caption_entities: String? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.from_chat_id = from_chat_id
            this.message_id = message_id
            this.caption = caption
            this.parse_mode = parse_mode
            this.caption_entities = caption_entities
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<CopyMessage>()
        }
    }
}

//@Multipart
//@POST("sendPhoto")
//interface SendPhoto : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    var photo: MultipartBody.Part
//    var caption: RequestBody?
//    var parse_mode: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendPhoto")
interface SendPhoto : Call<Response<Message>> {

    var chat_id: ChatId
    var photo: String
    var caption: String?
    var parse_mode: ParseMode?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            photo: String,
            caption: String? = null,
            parse_mode: ParseMode? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.photo = photo
            this.caption = caption
            this.parse_mode = parse_mode
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendPhoto>()
        }
    }
}

//@Multipart
//@POST("sendAudio")
//interface SendAudio : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName audio: MultipartBody.Part
//    var duration: RequestBody?
//    var performer: RequestBody?
//    var title: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendAudio")
interface SendAudio : Call<Response<Message>> {

    var chat_id: ChatId
    var audio: String
    var duration: Int?
    var performer: String?
    var title: String?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            audio: String,
            duration: Int? = null,
            performer: String? = null,
            title: String? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.audio = audio
            this.duration = duration
            this.performer = performer
            this.title = title
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendAudio>()
        }
    }
    
}

//@POST("sendDocument")
//@Multipart
//interface SendDocument : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName document: MultipartBody.Part
//    var caption: RequestBody?
//    var parse_mode: RequestBody?
//    var disable_content_type_detection: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendDocument")
interface SendDocument : Call<Response<Message>> {

    var chat_id: ChatId
    var document: String
    var caption: String?
    var parse_mode: ParseMode?
    var disable_content_type_detection: Boolean?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            document: String,
            caption: String? = null,
            parse_mode: ParseMode? = null,
            disable_content_type_detection: Boolean? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.document = document
            this.caption = caption
            this.parse_mode = parse_mode
            this.disable_content_type_detection = disable_content_type_detection
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendDocument>()
        }
    }
}
typealias RequestBody = Any?

//@Multipart
//@POST("sendVideo")
//interface SendVideo : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName video: MultipartBody.Part
//    var duration: RequestBody?
//    var width: RequestBody?
//    var height: RequestBody?
//    var caption: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendVideo")
interface SendVideo : Call<Response<Message>> {

    var chat_id: ChatId
    var video: String
    var duration: Int?
    var width: Int?
    var height: Int?
    var caption: String?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            video: String,
            duration: Int? = null,
            width: Int? = null,
            height: Int? = null,
            caption: String? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.video = video
            this.duration = duration
            this.width = width
            this.height = height
            this.caption = caption
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendVideo>()
        }
    }
}

@FormUrlEncoded
@POST("sendGame")
interface SendGame : Call<Response<Message>> {

    var chat_id: ChatId
    var game_short_name: String
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            game_short_name: String,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.game_short_name = game_short_name
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendGame>()
        }
    }
}

//@Multipart
//@POST("sendAnimation")
//interface SendAnimation : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName animation: MultipartBody.Part
//    var duration: RequestBody?
//    var width: RequestBody?
//    var height: RequestBody?
//    var caption: RequestBody?
//    var parse_mode: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendAnimation")
interface SendAnimation : Call<Response<Message>> {

    var chat_id: ChatId
    var animation: String
    var duration: Int?
    var width: Int?
    var height: Int?
    var caption: String?
    var parse_mode: ParseMode?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            animation: String,
            duration: Int? = null,
            width: Int? = null,
            height: Int? = null,
            caption: String? = null,
            parse_mode: ParseMode? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.animation = animation
            this.duration = duration
            this.width = width
            this.height = height
            this.caption = caption
            this.parse_mode = parse_mode
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendAnimation>()
        }
    }
}
//
//@Multipart
//@POST("sendVoice")
//interface SendVoice : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName voice: MultipartBody.Part
//    var caption: RequestBody?
//    var parse_mode: RequestBody?
//    var caption_entities: RequestBody?
//    var duration: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendVoice")
interface SendVoice : Call<Response<Message>> {

    var chat_id: ChatId
    var voice: String
    var caption: String?
    var parse_mode: ParseMode?
    var caption_entities: String?
    var duration: Int?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            voice: String,
            caption: String? = null,
            parse_mode: ParseMode? = null,
            caption_entities: String? = null,
            duration: Int? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.voice = voice
            this.caption = caption
            this.parse_mode = parse_mode
            this.caption_entities = caption_entities
            this.duration = duration
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendVoice>()
        }
    }
}

//@POST("sendVideoNote")
//@Multipart
//interface SendVideoNote : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName videoNote: MultipartBody.Part
//    var duration: RequestBody?
//    var length: RequestBody?
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendVideoNote")
interface SendVideoNote : Call<Response<Message>> {

    var chat_id: ChatId
    var video_note: String
    var duration: Int?
    var length: Int?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            video_note: String,
            duration: Int? = null,
            length: Int? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.video_note = video_note
            this.duration = duration
            this.length = length
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendVideoNote>()
        }
    }
}

annotation class Multipart

//@Multipart
//@POST("sendMediaGroup")
//interface SendMediaGroup : Call<Response<List<Message>>> {
//    @JsName body: List<MultipartBody.Part>
//}

@FormUrlEncoded
@POST("sendLocation")
interface SendLocation : Call<Response<Message>> {

    var chat_id: ChatId
    var latitude: Float
    var longitude: Float
    var live_period: Int?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    var proximity_alert_radius: Int?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            latitude: Float,
            longitude: Float,
            live_period: Int? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null,
            proximity_alert_radius: Int? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.latitude = latitude
            this.longitude = longitude
            this.live_period = live_period
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.proximity_alert_radius = proximity_alert_radius
            this.unsafeCast<SendLocation>()
        }
    }
}

@FormUrlEncoded
@POST("editMessageLiveLocation")
interface EditMessageLiveLocation : Call<Response<Message>> {

    var chat_id: ChatId?
    var message_id: Long?
    var inline_message_id: String?
    var latitude: Float
    var longitude: Float
    var reply_markup: ReplyMarkup?
    var proximity_alert_radius: Int?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            inline_message_id: String? = null,
            latitude: Float,
            longitude: Float,
            reply_markup: ReplyMarkup? = null,
            proximity_alert_radius: Int? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.inline_message_id = inline_message_id
            this.latitude = latitude
            this.longitude = longitude
            this.reply_markup = reply_markup
            this.proximity_alert_radius = proximity_alert_radius
            this.unsafeCast<EditMessageLiveLocation>()
        }
    }
}

annotation class FormUrlEncoded

@FormUrlEncoded
@POST("stopMessageLiveLocation")
interface StopMessageLiveLocation : Call<Response<Message>> {

    var chat_id: ChatId?
    var message_id: Long?
    var inline_message_id: String?
    var reply_markup: ReplyMarkup?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            inline_message_id: String? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.inline_message_id = inline_message_id
            this.reply_markup = reply_markup
            this.unsafeCast<StopMessageLiveLocation>()
        }
    }
}

@FormUrlEncoded
@POST("sendVenue")
interface SendVenue : Call<Response<Message>> {

    var chat_id: ChatId
    var latitude: Float
    var longitude: Float
    var title: String
    var address: String
    var foursquare_id: String?
    var foursquare_type: String?
    var google_place_id: String?
    var google_place_type: String?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            latitude: Float,
            longitude: Float,
            title: String,
            address: String,
            foursquare_id: String? = null,
            foursquare_type: String? = null,
            google_place_id: String? = null,
            google_place_type: String? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.latitude = latitude
            this.longitude = longitude
            this.title = title
            this.address = address
            this.foursquare_id = foursquare_id
            this.foursquare_type = foursquare_type
            this.google_place_id = google_place_id
            this.google_place_type = google_place_type
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendVenue>()
        }
    }
}

@POST("sendContact")
@FormUrlEncoded
interface SendContact : Call<Response<Message>> {

    var chat_id: ChatId
    var phone_number: String
    var first_name: String
    var last_name: String?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            phone_number: String,
            first_name: String,
            last_name: String? = null,
            disable_notification: Boolean? = null,
            reply_to_message_id: Long? = null,
            allow_sending_without_reply: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.phone_number = phone_number
            this.first_name = first_name
            this.last_name = last_name
            this.disable_notification = disable_notification
            this.reply_to_message_id = reply_to_message_id
            this.allow_sending_without_reply = allow_sending_without_reply
            this.reply_markup = reply_markup
            this.unsafeCast<SendContact>()
        }
    }
}

//@FormUrlEncoded
//@POST("sendPoll")
//interface SendPoll : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    @JsName(PollFields.QUESTION) question: String
//    @JsName(PollFields.OPTIONS) options: String
//    @JsName(PollFields.IS_ANONYMOUS) isAnonymous: Boolean?
//    @JsName(PollFields.TYPE) type: PollType?
//    @JsName(PollFields.ALLOWS_MULTIPLE_ANSWERS) allowsMultipleAnswers: Boolean?
//    @JsName(PollFields.CORRECT_OPTION_ID) correctOptionId: Int?
//    @JsName(PollFields.EXPLANATION) explanation: String?
//    @JsName(PollFields.EXPLANATION_PARSE_MODE) explanationParseMode: ParseMode?
//    @JsName(PollFields.OPEN_PERIOD) openPeriod: Int?
//    @JsName(PollFields.CLOSE_DATE) closeDate: Long?
//    @JsName(PollFields.IS_CLOSED) isClosed: Boolean?
//    var disable_notification: Boolean?
//    var reply_to_message_id: Long?
//    var allow_sending_without_reply: Boolean?
//    var reply_markup: ReplyMarkup?
//}

@FormUrlEncoded
@POST("sendChatAction")
interface SendChatAction : Call<Response<Boolean>> {

    var chat_id: ChatId
    var action: ChatAction
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            action: ChatAction
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.action = action
            this.unsafeCast<SendChatAction>()
        }
    }
}

@GET("getUserProfilePhotos")
interface GetUserProfilePhotos : Call<Response<UserProfilePhotos>> {

    var user_id: Long
    var offset: Long?
    var limit: Int?
    
    companion object {
        inline operator fun invoke(
            user_id: Long,
            offset: Long? = null,
            limit: Int? = null
        ) = with(jsObj) {
            this.user_id = user_id
            this.offset = offset
            this.limit = limit
            this.unsafeCast<GetUserProfilePhotos>()
        }

    }
}

//@GET("getFile")
//interface GetFile : Call<Response<File>> {
//
//    var file_id: String
//}
//
//@GET
//interface DownloadFile : Call<ResponseBody> {
//
//    @Url customUrl: String
//}

@FormUrlEncoded
@POST("banChatMember")
interface BanChatMember : Call<Response<Boolean>> {

    var chat_id: ChatId
    var user_id: Long
    var until_date: Long?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            user_id: Long,
            until_date: Long? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.user_id = user_id
            this.until_date = until_date
            this.unsafeCast<BanChatMember>()
        }
    }
}

@FormUrlEncoded
@POST("unbanChatMember")
interface UnbanChatMember : Call<Response<Boolean>> {

    var chat_id: ChatId
    var user_id: Long
    var only_if_banned: Boolean?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            user_id: Long,
            only_if_banned: Boolean? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.user_id = user_id
            this.only_if_banned = only_if_banned
            this.unsafeCast<UnbanChatMember>()
        }
    }
}

@FormUrlEncoded
@POST("restrictChatMember")
interface RestrictChatMember : Call<Response<Boolean>> {

    var chat_id: ChatId
    var user_id: Long
    var permissions: String
    var until_date: Long?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            user_id: Long,
            permissions: String,
            until_date: Long? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.user_id = user_id
            this.permissions = permissions
            this.until_date = until_date
            this.unsafeCast<RestrictChatMember>()
        }
    }
}

@FormUrlEncoded
@POST("promoteChatMember")
interface PromoteChatMember : Call<Response<Boolean>> {

    var chat_id: ChatId
    var user_id: Long
    var is_anonymous: Boolean?
    var can_change_info: Boolean?
    var can_post_messages: Boolean?
    var can_edit_messages: Boolean?
    var can_delete_messages: Boolean?
    var can_invite_users: Boolean?
    var can_restrict_members: Boolean?
    var can_pin_messages: Boolean?
    var can_promote_members: Boolean?
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            user_id: Long,
            is_anonymous: Boolean? = null,
            can_change_info: Boolean? = null,
            can_post_messages: Boolean? = null,
            can_edit_messages: Boolean? = null,
            can_delete_messages: Boolean? = null,
            can_invite_users: Boolean? = null,
            can_restrict_members: Boolean? = null,
            can_pin_messages: Boolean? = null,
            can_promote_members: Boolean? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.user_id = user_id
            this.is_anonymous = is_anonymous
            this.can_change_info = can_change_info
            this.can_post_messages = can_post_messages
            this.can_edit_messages = can_edit_messages
            this.can_delete_messages = can_delete_messages
            this.can_invite_users = can_invite_users
            this.can_restrict_members = can_restrict_members
            this.can_pin_messages = can_pin_messages
            this.can_promote_members = can_promote_members
            this.unsafeCast<PromoteChatMember>()
        }
    }
}

@FormUrlEncoded
@POST("setChatPermissions")
interface SetChatPermissions : Call<Response<Boolean>> {

    var chat_id: ChatId
    var permissions: String
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            permissions: String
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.permissions = permissions
            this.unsafeCast<SetChatPermissions>()
        }
    }
}

@FormUrlEncoded
@POST("exportChatInviteLink")
interface ExportChatInviteLink : Call<Response<String>> {

    var chat_id: ChatId
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<ExportChatInviteLink>()
        }
    }
}

//@Multipart
//@POST("setChatPhoto")
//interface SetChatPhoto : Call<Response<Boolean>> {
//
//    var chat_id: ChatId
//    var photo: MultipartBody.Part
//}

@FormUrlEncoded
@POST("deleteChatPhoto")
interface DeleteChatPhoto : Call<Response<Boolean>> {

    var chat_id: ChatId
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<DeleteChatPhoto>()
        }
    }
}

@FormUrlEncoded
@POST("setChatTitle")
interface SetChatTitle : Call<Response<Boolean>> {

    var chat_id: ChatId
    var title: String
    
    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            title: String
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.title = title
            this.unsafeCast<SetChatTitle>()
        }
    }
}

@FormUrlEncoded
@POST("setChatDescription")
interface SetChatDescription : Call<Response<Boolean>> {
    var chat_id: ChatId
    var description: String

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            description: String
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.description = description
            this.unsafeCast<SetChatDescription>()
        }
    }
}

@FormUrlEncoded
@POST("pinChatMessage")
interface PinChatMessage : Call<Response<Boolean>> {

    var chat_id: ChatId
    var message_id: Long
    var disable_notification: Boolean?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            message_id: Long,
            disable_notification: Boolean? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.disable_notification = disable_notification
            this.unsafeCast<PinChatMessage>()
        }
    }
}

@FormUrlEncoded
@POST("unpinChatMessage")
interface UnpinChatMessage : Call<Response<Boolean>> {

    var chat_id: ChatId
    var message_id: Long?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            message_id: Long? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.unsafeCast<UnpinChatMessage>()
        }
    }
}

@FormUrlEncoded
@POST("unpinAllChatMessages")
interface UnpinAllChatMessages : Call<Response<Boolean>> {

    var chat_id: ChatId

    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<UnpinAllChatMessages>()
        }
    }
}

@FormUrlEncoded
@POST("leaveChat")
interface LeaveChat : Call<Response<Boolean>> {

    var chat_id: ChatId

    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<LeaveChat>()
        }
    }
}

@GET("getChat")
interface GetChat : Call<Response<Chat>> {

    var chat_id: ChatId

    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<GetChat>()
        }
    }
}

@GET("getChatAdministrators")
interface GetChatAdministrators : Call<Response<List<ChatMember>>> {
    var chat_id: ChatId

    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<GetChatAdministrators>()
        }
    }
}

@GET("getChatMemberCount")
interface GetChatMemberCount : Call<Response<Int>> {

    var chat_id: ChatId

    companion object {
        inline operator fun invoke(
            chat_id: ChatId
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.unsafeCast<GetChatMemberCount>()
        }
    }
}

@GET("getChatMember")
interface GetChatMember : Call<Response<ChatMember>> {

    var chat_id: ChatId
    var user_id: Long
}

@FormUrlEncoded
@POST("setChatStickerSet")
interface SetChatStickerSet : Call<Response<Boolean>> {

    var chat_id: ChatId
    var sticker_set_name: String
}

@FormUrlEncoded
@POST("deleteChatStickerSet")
interface DeleteChatStickerSet : Call<Response<Boolean>> {

    var chat_id: ChatId
}

@FormUrlEncoded
@POST("answerCallbackQuery")
interface AnswerCallbackQuery : Call<Response<Boolean>> {

    var callback_query_id: String
    var text: String?
    var show_alert: Boolean?
    var url: String?
    var cache_time: Int?
}

@GET("logOut")
interface LogOut : Call<Response<Boolean>>

@GET("close")
interface Close : Call<Response<Boolean>>

/**
 * Updating messages
 */

@FormUrlEncoded
@POST("editMessageText")
interface EditMessageText : Call<Response<Message>> {

    var chat_id: ChatId?
    var message_id: Long?
    var inline_message_id: String?
    var text: String
    var parse_mode: ParseMode?
    var disable_web_page_preview: Boolean?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            inline_message_id: String? = null,
            text: String,
            parse_mode: ParseMode? = null,
            disable_web_page_preview: Boolean? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.inline_message_id = inline_message_id
            this.text = text
            this.parse_mode = parse_mode
            this.disable_web_page_preview = disable_web_page_preview
            this.reply_markup = reply_markup
            this.unsafeCast<EditMessageText>()
        }
    }
}

@FormUrlEncoded
@POST("editMessageCaption")
interface EditMessageCaption : Call<Response<Message>> {

    var chat_id: ChatId?
    var message_id: Long?
    var inline_message_id: String?
    var caption: String
    var parse_mode: ParseMode?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            inline_message_id: String? = null,
            caption: String,
            parse_mode: ParseMode? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.inline_message_id = inline_message_id
            this.caption = caption
            this.parse_mode = parse_mode
            this.reply_markup = reply_markup
            this.unsafeCast<EditMessageCaption>()
        }
    }
}

@FormUrlEncoded
@POST("editMessageMedia")
interface EditMessageMedia : Call<Response<Message>> {

    var chat_id: ChatId?
    var message_id: Long?
    var inline_message_id: String?
    var media: InputMedia
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            inline_message_id: String? = null,
            media: InputMedia,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.inline_message_id = inline_message_id
            this.media = media
            this.reply_markup = reply_markup
            this.unsafeCast<EditMessageMedia>()
        }
    }
}

@FormUrlEncoded
@POST("editMessageReplyMarkup")
interface EditMessageReplyMarkup : Call<Response<Message>> {

    var chat_id: ChatId?
    var message_id: Long?
    var inline_message_id: String?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            inline_message_id: String? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.inline_message_id = inline_message_id
            this.reply_markup = reply_markup
            this.unsafeCast<EditMessageReplyMarkup>()
        }
    }
}

@FormUrlEncoded
@POST("stopPoll")
interface StopPoll : Call<Response<Poll>> {

    var chat_id: ChatId?
    var message_id: Long?
    var reply_markup: ReplyMarkup?

    companion object {
        inline operator fun invoke(
            chat_id: ChatId? = null,
            message_id: Long? = null,
            reply_markup: ReplyMarkup? = null
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.reply_markup = reply_markup
            this.unsafeCast<StopPoll>()
        }
    }
}

@FormUrlEncoded
@POST("deleteMessage")
interface DeleteMessage : Call<Response<Boolean>> {

    var chat_id: ChatId
    var message_id: Long

    companion object {
        inline operator fun invoke(
            chat_id: ChatId,
            message_id: Long
        ) = with(jsObj) {
            this.chat_id = chat_id
            this.message_id = message_id
            this.unsafeCast<DeleteMessage>()
        }
    }
}

/***
 * Stickers
 */

//@Multipart
//@POST("sendSticker")
//interface SendSticker : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    var sticker: MultipartBody.Part
//    var disable_notification: RequestBody?
//    var reply_to_message_id: RequestBody?
//    var allow_sending_without_reply: RequestBody?
//    var reply_markup: RequestBody?
//}

@FormUrlEncoded
@POST("sendSticker")
interface SendSticker : Call<Response<Message>> {

    var chat_id: ChatId
    var fileId: String
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
}

@GET("getStickerSet")
interface GetStickerSet : Call<Response<StickerSet>> {

    var name: String
}

//@Multipart
//@POST("uploadStickerFile")
//interface UploadStickerFile : Call<Response<File>> {
//
//    var user_id: RequestBody
//    var png_sticker: MultipartBody.Part
//}
//
//@Multipart
//@POST("createNewStickerSet")
//interface CreateNewStickerSet : Call<Response<Boolean>> {
//
//    var user_id: RequestBody
//    var name: RequestBody
//    var title: RequestBody
//    var png_sticker: MultipartBody.Part
//    var emojis: RequestBody
//    var contains_masks: RequestBody?
//    var mask_position: RequestBody?
//}

@FormUrlEncoded
@POST("createNewStickerSet")
interface CreateNewStickerSet : Call<Response<Boolean>> {

    var user_id: Long
    var name: String
    var title: String
    var png_sticker: String
    var emojis: String
    var contains_masks: Boolean?
    var mask_position: MaskPosition?
}

//@Multipart
//@POST("addStickerToSet")
//interface AddStickerToSet : Call<Response<Boolean>> {
//
//    var user_id: RequestBody
//    var name: RequestBody
//    var png_sticker: MultipartBody.Part
//    var emojis: RequestBody
//    var mask_position: RequestBody?
//}

@FormUrlEncoded
@POST("addStickerToSet")
interface AddStickerToSet : Call<Response<Boolean>> {

    var user_id: Long
    var name: String
    var png_sticker: String
    var emojis: String
    var mask_position: MaskPosition?
}

@FormUrlEncoded
@POST("setStickerPositionInSet")
interface SetStickerPositionInSet : Call<Response<Boolean>> {

    var sticker: String
    var position: Int
}

@FormUrlEncoded
@POST("deleteStickerFromSet")
interface DeleteStickerFromSet : Call<Response<Boolean>> {

    var sticker: String
}

/**
 * Payment
 */

@FormUrlEncoded
@POST("sendInvoice")
interface SendInvoice : Call<Response<Message>> {

    var chat_id: ChatId
    var title: String
    var description: String
    var payload: String
    var provider_token: String
    var start_parameter: String
    var currency: String
//    var prices: LabeledPriceList
    var provider_data: String?
    var photo_url: String?
    var photo_size: Int?
    var photo_width: Int?
    var photo_height: Int?
    var need_name: Boolean?
    var need_phone_number: Boolean?
    var need_email: Boolean?
    var need_shipping_address: Boolean?
    var send_phone_number_to_provider: Boolean?
    var send_email_to_provider: Boolean?
    var is_flexible: Boolean?
    var disable_notification: Boolean?
    var reply_to_message_id: Long?
    var allow_sending_without_reply: Boolean?
    var reply_markup: ReplyMarkup?
}

@FormUrlEncoded
@POST("answerShippingQuery")
interface AnswerShippingQuery : Call<Response<Boolean>> {

    var shipping_query_id: String
    var ok: Boolean
    var shipping_options: List<ShippingOption>?
    var error_message: String?
}

@FormUrlEncoded
@POST("answerPreCheckoutQuery")
interface AnswerPreCheckoutQuery : Call<Response<Boolean>> {

    var pre_checkout_query_id: String
    var ok: Boolean
    var error_message: String?
}

@FormUrlEncoded
@POST("answerInlineQuery")
interface AnswerInlineQuery : Call<Response<Boolean>> {

    var inline_query_id: String
    var inlineQueryResults: String
    var cache_time: Int?
    var is_personal: Boolean
    var next_offset: String?
    var switch_pm_text: String?
    var switch_pm_parameter: String?
}

@GET("getMyCommands")
interface GetMyCommands : Call<Response<List<BotCommand>>>

@FormUrlEncoded
@POST("setMyCommands")
interface SetMyCommands : Call<Response<Boolean>> {
    var commands: Array<BotCommand>

    companion object {
        inline operator fun invoke(
            vararg commands: BotCommand
        ) = with(jsObj) {
            this.commands = commands
            this.unsafeCast<SetMyCommands>()
        }
    }
}

//@FormUrlEncoded
//@POST(DiceFields.SEND_DICE_OP_NAME)
//interface SendDice : Call<Response<Message>> {
//
//    var chat_id: ChatId
//    emoji: DiceEmoji?
//    var disable_notification: Boolean?
//    var reply_to_message_id: Long?
//    var allow_sending_without_reply: Boolean?
//    var reply_markup: ReplyMarkup?
//}

@FormUrlEncoded
@POST("setChatAdministratorCustomTitle")
interface SetChatAdministratorCustomTitle : Call<Response<Boolean>> {

    var chat_id: ChatId
    var user_id: Long
    var custom_title: String
}


annotation class POST(val value: String)

annotation class GET(val value: String)
