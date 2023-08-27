package com.tgse.index.new.handle

import com.github.kotlintelegrambot.entities.ReplyMarkup
import com.github.kotlintelegrambot.network.EditMessageText

val Enrol.link get() = "https://t.me/${linkableName}"

sealed interface Enrol {
    val uuid:String
    //base information of a telegram chat
//    val joinLink: String? // https://t.me/joinchat/xxxxx
    val linkableName: String //@xxx but @
    val chatId: Long?
    val type:String //(supergroup,group),channel,bot
    val title: String
    //information of a record
    val tags: Collection<String>? //包含`#`
    val category: String?
    val description: String?
    //more information for log
    val membersCount: Long?
    val createTime: Long
    //user infos
    val creatorChatId: Long
    val creatorUserId: Long
    val creatorUsername: String
    val creatorFullname: String
    //reviewer infos
    val reviewerId: Long?
    val reviewerUsername:String?
    val reviewerFullname:String?
    val lastUpdate: Long

    interface TempEnrol:Enrol {
        val hasSent:Boolean
        val isPassed:Boolean
        val lastMessageId:Long
    }
    interface RecordEnrol:Enrol {
        val hubChannelMessageId: Long
    }

}

typealias TempEnrol = Enrol.TempEnrol
typealias RecordEnrol = Enrol.RecordEnrol


fun Record.detail() {
    TODO()
}


private fun makeDetail(
    title: String,
    tags: Collection<String>?,
    category: String?,
    description: String?,
    link: String?,
    username: String?,
) = TelegramMessageBuilder().run {
    line(subtitle("标题",link(title,if (username != null) "https://t.me/$username" else link!!)))
    line(subtitle("标签",tags?.takeIf { it.isNotEmpty() }?.joinToString(" ") ?: "暂无"))
    line(subtitle("分类",category ?: "暂无"))
    line(subtitle("简介",description?.run { replace("<", "&lt;").replace(">", "&gt;") } ?: ""))
    toString()
}
fun buildTelegramMessage(chatId: Long,messageId: Long,block:TelegramMessageBuilder.()->Unit) =
    TelegramMessageBuilder().apply(block).let {
        EditMessageText(chat_id =  chatId, message_id = messageId,text = it.toString(),reply_markup = it.keyboard)
    }

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
    var keyboard:ReplyMarkup?=null

}