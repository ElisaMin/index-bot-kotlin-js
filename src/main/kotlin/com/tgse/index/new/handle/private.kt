/**
 * 私聊中
 */
package com.tgse.index.new.handle

import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
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
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.heizi.workers.bot.index.CustomReplies


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
    if(Rejecting.isUserFreezed(chatId)) {
        TODO()
    }
    if (Rejecting.isEnrollBlock(enrolId)) {
        TODO()
    }
    Enroll()
    if (Record.exsisted()) {
        TODO()
    }
    if (!checkPermission()) {
        TODO()
    }
    Record.submint()
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
    val keywords = directKeyboardMarkup()
    SendMessage(chatId.toString(), msgAsync.await().toString(), reply_markup = keywords, parse_mode = ParseMode.HTML)
}
fun MessageFactories.directKeyboardMarkup(
    keywords: Array<String> = this.keywords,
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

fun MessageFactories.directInlineKeyboardMarkup(
    queryHeader:String,
    keywords: Array<String> = this.keywords
) = keywords
    .map { InlineKeyboardButton.CallbackData(
        text = it,
        callback_data = "$queryHeader?$keywords"
    ) }
    .chunked(3)
    .let(::InlineKeyboardMarkup)
