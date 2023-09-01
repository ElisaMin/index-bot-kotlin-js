package com.tgse.index.new.db

import com.tgse.index.new.handle.Enrol
import com.tgse.index.new.search.Enrols

interface DatabaseAlisObject {
    suspend fun updateLastMessageId(uuid: String, it: Long)

    suspend fun updateAwaitTimeout(chatId: Long, noticeMsgId: Long)

    suspend fun findEnrolByUUID(uuid: String): Enrol?

    suspend fun categories(): Array<String>

    suspend fun getTimeout(chatId: Long?, messageId: Long): Long?

    suspend fun updateEnrol(enrol: Enrol)
    // returns null if empty or it's not found
    suspend fun searchEnrolsByKeyword(keyword: String) :Enrols?
    suspend fun searchEnrolsByTag(it: List<String>): Enrols?
    suspend fun searchEnrolsByCategory(keyword: String): Enrols?

    suspend fun Enrol.score():Float
}
interface AwaitInfo {
    val chatId:Long
    val messageId:Long
    val callbackData:String
    val timeout:Long?
}