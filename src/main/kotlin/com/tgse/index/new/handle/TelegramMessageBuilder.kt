package com.tgse.index.new.handle

import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.ReplyMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.network.EditMessageText
import com.github.kotlintelegrambot.network.SendMessage


@Suppress("NOTHING_TO_INLINE")
class TelegramMessageBuilder(
    val builder: StringBuilder = StringBuilder()
) {
    inline fun line(s: String="") = builder.appendLine(s)
    inline fun tag(tag:String,s: String,attr:String="") = "<$tag $attr>$s</$tag>"
    inline fun b(s: String) = tag("b",s)
    inline fun link(s: String,href:String) = tag("a",s,"href=\"$href\"")
    //code
    inline fun code(s: String) = tag("code",s)
    inline fun del(s: String) = tag("del",s)
    inline fun subtitle(title: String,s: String) = "${b(title)}: $s"
    override fun toString(): String = builder.toString()
    fun inlineKeyboard(function: InlineKeyboardBuilder.() -> Unit) {
        keyboard = InlineKeyboardMarkup(InlineKeyboardBuilder().apply(function).keyboard)
    }
    var keyboard: ReplyMarkup?=null
    inner class InlineKeyboardBuilder {
        inner class InlineKeyboardRowBuilder {
            val row = mutableListOf<InlineKeyboardButton>()
            fun callbackButton(text:String,callbackData:String) {
                row.add(InlineKeyboardButton.CallbackData(text,callbackData))
            }
        }
        val keyboard = mutableListOf<List<InlineKeyboardButton>>()

        fun row(block:InlineKeyboardRowBuilder.()->Unit) {
            keyboard.add(InlineKeyboardRowBuilder().apply(block).row)
        }
    }
    fun toSendMessage(chatId: ChatId) = SendMessage(chatId,toString(),reply_markup = keyboard)
}
fun buildEditMessage(chatId: Long, messageId: Long, block:TelegramMessageBuilder.()->Unit) =
    TelegramMessageBuilder().apply(block)
.let { EditMessageText(chat_id =  chatId, message_id = messageId,text = it.toString(),reply_markup = it.keyboard) }

//fun buildSendMessage(chatId: Long, block:TelegramMessageBuilder.()->Unit) = TelegramMessageBuilder().apply(block).let { SendMessage(chatId,it.toString(),reply_markup = it.keyboard) }