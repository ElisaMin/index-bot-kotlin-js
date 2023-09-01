package com.tgse.index.new

import com.github.kotlintelegrambot.entities.InlineQuery
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.network.SendMessage
import com.tgse.index.new.db.DatabaseAlisObject
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
    override val db: DatabaseAlisObject
        get() = TODO("Not yet implemented")

    operator fun invoke(update: Update) {

        require(update.isMessageOrCallback) {
            "Update must be a message or callback"
        }
        if (Rejecting.checkUnservicing(chatId)) return
        // todo: more check
    }
}
inline val Update.isMessageOrCallback: Boolean get() {
    return this.message?.text != null || this.callback_query != null
}
