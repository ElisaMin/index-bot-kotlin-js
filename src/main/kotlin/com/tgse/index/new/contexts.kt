package com.tgse.index.new

import com.github.kotlintelegrambot.entities.InlineQuery
import com.github.kotlintelegrambot.network.SendMessage
import com.tgse.index.new.db.DatabaseAlisObject
import com.tgse.index.new.handle.Enrol
import kotlinx.coroutines.CoroutineScope
import me.heizi.workers.bot.index.BotApiProvider
import me.heizi.workers.bot.index.CustomReplies
import kotlin.reflect.KProperty1

internal typealias BypassContextBlock<C>  = suspend C.()->Unit

interface FunctionContext {
    val chatId:Long
    val chatType: InlineQuery.ChatType
    val api: BotApiProvider
    val isForReviewers:Boolean
    val db: DatabaseAlisObject
}

interface UpdateHandlerScope: CoroutineScope {
    suspend infix fun String.isaCommandFor(block:BypassScope<CommandContext>.(data:String)->Unit)
    suspend infix fun String.isaCallbackFor(block:BypassScope<CallbackContext>.() -> Unit)
    suspend infix fun String.isReplyFor(block:BypassScope<ReplyForUpdateContext>.() -> Unit)
}

interface CallbackScope {
    val data:String?
    val enrol: Enrol?
    fun next(path:String?=null,callbackScope:suspend CallbackScope.()->Unit)
    fun next():String?
    fun param():String?
}
interface CallbackContext:CallbackScope,FunctionContext {
    val messageId:Long
    val callbackId:String
    suspend fun answerCallback()
}
interface ReplyScope {
    val data:String?
    val enrol: Enrol?
    val dateReplyTo:Long
    val editDateReplyTo:Long?
    val idReplyTo:Long
    val messageReplyTo:String
//    val hasEdit:Boolean
    fun next(path: String?, callbackScope: suspend ReplyScope.() -> Unit)
    fun next():String?
}

interface ReplyForUpdateContext:ReplyScope,FunctionContext

context(FunctionContext)
suspend inline fun KProperty1<CustomReplies, String?>.send() = api.execute(
    SendMessage(chatId, CustomReplies[this])
)


//@Suppress("NOTHING_TO_INLINE")
inline val KProperty1<CustomReplies, String?>.value get()  = CustomReplies[this]

context(FunctionContext)
suspend inline fun String.send() = api.execute(SendMessage(chatId,this))
interface CommandContext:FunctionContext {
    val data:String?
}
