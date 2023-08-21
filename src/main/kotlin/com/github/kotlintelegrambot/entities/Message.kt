package com.github.kotlintelegrambot.entities

import com.github.kotlintelegrambot.entities.dice.Dice
import com.github.kotlintelegrambot.entities.files.*
import com.github.kotlintelegrambot.entities.payments.SuccessfulPayment
import com.github.kotlintelegrambot.entities.polls.Poll
import com.github.kotlintelegrambot.entities.stickers.Sticker

data class Message(
    val message_id: Long,
    val from: User? = null,
    val sender_chat: Chat? = null,
    val date: Long,
    val chat: Chat,
    val forward_from: User? = null,
    val forward_from_chat: Chat? = null,
    val forward_from_message_id: Int? = null,
    val forward_signature: String? = null,
    val forward_sender_name: String? = null,
    val forward_date: Int? = null,
    val reply_to_message: Message? = null,
    val via_bot: User? = null,
    val edit_date: Int? = null,
    val media_group_id: String? = null,
    val author_signature: String? = null,
    val text: String? = null,
    val entities: List<MessageEntity>? = null,
    val caption_entities: List<MessageEntity>? = null,
    val audio: Audio? = null,
    val document: Document? = null,
    val animation: Animation? = null,
    val dice: Dice? = null,
    val game: Game? = null,
    val photo: List<PhotoSize>? = null,
    val sticker: Sticker? = null,
    val video: Video? = null,
    val voice: Voice? = null,
    val video_note: VideoNote? = null,
    val caption: String? = null,
    val contact: Contact? = null,
    val location: Location? = null,
    val venue: Venue? = null,
    val new_chat_members: List<User>? = null,
    val poll: Poll? = null,
    val left_chat_member: User? = null,
    val new_chat_title: String? = null,
    val new_chat_photo: List<PhotoSize>? = null,
    val delete_chat_photo: Boolean? = null,
    val group_chat_created: Boolean? = null,
    val supergroup_chat_created: Boolean? = null,
    val channel_chat_created: Boolean? = null,
    val migrate_to_chat_id: Long? = null,
    val migrate_from_chat_id: Long? = null,
    val invoice: Invoice? = null,
    val successful_payment: SuccessfulPayment? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val proximity_alert_triggered: ProximityAlertTriggered? = null,
) {
    inline val messageId: Long? get() = message_id
}