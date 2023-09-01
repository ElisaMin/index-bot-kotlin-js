package com.tgse.index.new.handle

import kotlin.js.Date

val Enrol.link get() = "https://t.me/${linkableName}"

sealed interface
Enrol {
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


fun Enrol.copy(
    title: String = this.title,
    linkableName: String = this.linkableName,
    description: String? = this.description,
    category: String? = this.category,
    tags: Collection<String>? = this.tags,
    reviewerFullname: String? = this.reviewerFullname,
    reviewerUsername: String? = this.reviewerUsername,
    reviewerId:Long? = this.reviewerId,
    lastUpdate: Long = Date.now().toLong(),
    isPassed: Boolean = (this as? TempEnrol)?.isPassed ?: false,
    hasSent: Boolean = (this as? TempEnrol)?.hasSent ?: true
): Enrol = TODO()
