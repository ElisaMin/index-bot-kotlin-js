package com.tgse.index.new

import com.github.kotlintelegrambot.entities.InlineQuery
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.network.SendMessage
import com.tgse.index.new.handle.Enrol
import com.tgse.index.new.services.Rejecting
import com.tgse.index.new.services.checkUnservicing
import kotlinx.coroutines.CoroutineScope
import me.heizi.workers.bot.index.BotApiProvider
import me.heizi.workers.bot.index.CustomReplies
import me.heizi.workers.bot.index.InnerContext
import kotlin.properties.Delegates
import kotlin.reflect.KProperty1


/**
 * 当前webhook要处理的信息
 *
 */
inline val currentUpdate get() = CurrentUpdate

interface FunctionContext {
    val chatId:Long
    val chatType:InlineQuery.ChatType
    val api:BotApiProvider
    val isForReviewers:Boolean
}
context(FunctionContext)
suspend inline fun KProperty1<CustomReplies, String?>.send() = api.execute(
    SendMessage(chatId, CustomReplies[this])
)

@Suppress("NOTHING_TO_INLINE")
inline val KProperty1<CustomReplies, String?>.value get()  = CustomReplies[this]
context(FunctionContext)
suspend inline fun String.send() = api.execute(SendMessage(chatId,this))
interface CommandContext:FunctionContext {
    val data:String?
}

class BypassScope<C:FunctionContext>(
    val type:String
) {

    val chains = mutableListOf<BypassContextBlock<C>>()

    private var otherwise = setOf("private","group","approve")

    @Suppress("NOTHING_TO_INLINE")
    private inline fun withType(type: String, noinline block: BypassContextBlock<C>) {
        if (type==this.type) {
            otherwise-=type
            chains.add(block)
        }
    }

    fun privateChat(block: BypassContextBlock<C>) = withType("private",block)
    fun groupChat(block: BypassContextBlock<C>) = withType("group",block)
    fun approveGroup(block: BypassContextBlock<C>) = withType("approve",block)

    fun all(vararg but: String,block: BypassContextBlock<C>) {
        if (but.isEmpty()) chains.add(block)
        else but.forEach { withType(it,block) }
    }
    fun otherwise(block: BypassContextBlock<C>) {
        otherwise.forEach {
            withType(it,block)
        }
    }
    fun disableRest(but: String?=null) = otherwise {
        when (but) {
            "private" -> CustomReplies::onlyPrivate.send()
            "group"-> CustomReplies::onlyGroup.send()
            else -> CustomReplies::disable.send()
        }
        Unit
    }
}


private typealias BypassContextBlock<C>  = suspend C.()->Unit
inline val Update.isMessageOrCallback: Boolean get() {
    return this.message?.text != null || this.callback_query != null
}
class UpdateHandlerScope: CoroutineScope by InnerContext.scope {
    suspend infix fun String.isaCommandFor(block:BypassScope<CommandContext>.(data:String)->Unit) {
    }
    suspend infix fun String.isaCallbackFor(block:BypassScope<CallbackContext>.() -> Unit) {
    }
    suspend infix fun String.isReplyFor(block:BypassScope<ReplyForUpdateContext>.() -> Unit) {

    }

}
interface CallbackScope {
    val data:String?
    val enrol:Enrol?
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
    val enrol:Enrol?
    val dateReplyTo:Long
    val editDateReplyTo:Long?
    val idReplyTo:Long
    val messageReplyTo:String
    val hasEdit:Boolean
    fun next(path: String?, callbackScope: suspend ReplyScope.() -> Unit)
    fun next():String?
}
interface ReplyForUpdateContext:ReplyScope,FunctionContext
//@JsName("handleUpdate")

//}
//
//fun handle(msg: Message) {
//@JsName("handleMessage")
//}
//    return handle(msg)
//    val msg = update.message?:return null
//    checkUpdate(update)
//suspend fun handle(update: Update) {
data object CurrentUpdate:FunctionContext {
    override var chatId by Delegates.notNull<Long>()
    var currentMessage: Long=-1; private set;
    override lateinit var chatType: InlineQuery.ChatType private set;
    override val api: BotApiProvider
        get() = TODO("Not yet implemented")
    override val isForReviewers: Boolean
        get() = TODO("Not yet implemented")

    operator fun invoke(update: Update) {

        require(update.isMessageOrCallback) {
            "Update must be a message or callback"
        }
        if (Rejecting.checkUnservicing(chatId)) return
        // todo: more check
    }
}
