/**
 * 私聊中
 */
package com.tgse.index.new.handle

import com.github.kotlintelegrambot.entities.InlineQuery
import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.entities.keyboard.KeyboardButton
import com.github.kotlintelegrambot.network.GetMe
import com.github.kotlintelegrambot.network.SendMessage
import com.tgse.index.area.msgFactory.MessageFactories
import com.tgse.index.area.msgFactory.factoryChain
import com.tgse.index.domain.repository.nick
import com.tgse.index.new.CommandContext
import com.tgse.index.new.CurrentUpdate
import com.tgse.index.new.services.Rejecting
import com.tgse.index.new.services.isEnrollBlock
import com.tgse.index.new.services.isUserFreezed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.heizi.workers.bot.index.BotApiProvider
import me.heizi.workers.bot.index.CustomReplies
import me.heizi.workers.bot.index.InnerContext
import kotlin.reflect.KProperty1


suspend fun CommandContext.startPrivate(data:String?) {

}

suspend fun CurrentUpdate.handlePrivateMessage() = coroutineScope {
   val state = launch { api.chatAction(chatId) }
    when {
        isCallback -> {

        }
        isCommand -> {
            val (command:String,content:String?) = data
            when(command) {
                "start" -> {
                    state.join()
                    if (content == null) {
                        api.execute(MessageFactories.startMsg(chatId))
                    }
                }

                "help" -> {
                    state.join()
                    CustomReplies::helpPrivate.send()
                }

                "enroll" -> {
                    state.join()
                    CustomReplies::enroll.send()
                }

                "setting" -> {
                    state.join()
                    CustomReplies::onlyGroup.send()
                }

                "cancel" -> {
                    TODO()
                }

                "update","mine" -> {
                    TODO()
                }
            }
        }
        messageIsEnroll -> {
            checkEnroll(data)
        }
    }
    Unit
}
suspend inline fun CurrentUpdate.checkEnroll(enrolId:String) {
    if(Rejecting.isUserFreezed(chatId.toLong())) {
        TODO()
    }
    if (Rejecting.isEnrollBlock(enrolId)) {
        TODO()
    }
    Enroll()
    if (Enroll.exsisted()) {
        TODO()
    }
    if (!checkPermission()) {
        TODO()
    }
    Enroll.submint()
}
/**
 * Message Factor
 */
private suspend fun MessageFactories.startMsg(chatId: dynamic) = coroutineScope {
    val factory = CustomReplies { CustomReplies::start }
        .factoryChain()
    val msgAsync = async {
        factory.updateBotName { api.execute(GetMe()).nick() }
    }
    val keywords = directKeyboards()
    SendMessage(chatId.toString(), msgAsync.await().toString(), reply_markup = keywords, parse_mode = ParseMode.HTML)
}
private fun MessageFactories.directKeyboards(
    keywords: Array<String> = this.keywords
): KeyboardReplyMarkup {
    val rows = keywords
        .map { KeyboardButton(it) }
        .chunked(3)
    return KeyboardReplyMarkup(
        rows,
        resize_keyboard = true,
        one_time_keyboard = false,
        selective = true
    )
}
