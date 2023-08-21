@file:Suppress("NOTHING_TO_INLINE")
package com.tgse.index.area.msgFactory

import com.github.kotlintelegrambot.entities.*
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.entities.keyboard.KeyboardButton
import com.github.kotlintelegrambot.network.*
import com.tgse.index.MismatchException
import com.tgse.index.domain.repository.nick
import com.tgse.index.domain.service.BlackListService
import com.tgse.index.infrastructure.provider.BotProvider
import com.tgse.index.domain.service.ClassificationService
import com.tgse.index.domain.service.ReplyService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.heizi.workers.bot.index.BotApiProvider
import me.heizi.workers.bot.index.CustomReplies
import me.heizi.workers.bot.index.contextGlobal

inline fun String.toTgMessage(chatId: dynamic) = SendMessage(chatId, this)

inline fun String.factoryChain() = FactoryMessage(this)


value class FactoryMessage(
    val msg:String
) {
    suspend inline fun updateBotName(crossinline botName: suspend  ()->String) = botName().let { msg.replace("\\{bot.username}".toRegex(), it) }
        .factoryChain()

    override fun toString() = msg
}

fun MessageFactories.cleanDirectsKeyboard(chatId: Long, messageId: Long) = run {
    EditMessageReplyMarkup(chatId.toString(), message_id =  messageId, reply_markup = InlineKeyboardMarkup(emptyList()))
}
fun MessageFactories.dailyMsg(chatId: Long, dailyIncreaseOfUser: Int, dailyActiveOfUser: Int,countOfUser: Int, countOfRecord: Long) = run {
    SendMessage(chatId.toString(), CustomReplies { CustomReplies::statisticsDaily }
        .replace("\\{dailyIncreaseOfUser\\}".toRegex(), dailyIncreaseOfUser.toString())
        .replace("\\{dailyActiveOfUser\\}".toRegex(), dailyActiveOfUser.toString())
        .replace("\\{countOfUser\\}".toRegex(), countOfUser.toString())
        .replace("\\{countOfRecord\\}".toRegex(), countOfRecord.toString()),
        parse_mode = ParseMode.HTML
    )
}
class NormalMsgFactory(
    private val classificationService: ClassificationService,
    override val replyService: ReplyService,
    override val botProvider: BotProvider
) : BaseMsgFactory(replyService, botProvider) {


    fun makeBlacklistJoinedReplyMsg(
        chatId: Long,
        replyType: String,
        manager: String,
        black: BlackListService.Black
    ): SendMessage {
        return SendMessage(
            chatId,
            replyService.messages[replyType]!!
                .replace("\\{code\\}".toRegex(), black.chatId?.toString() ?: black.username!!)
                .replace("\\{manager\\}".toRegex(), manager)
                .replace("\\{black\\}".toRegex(), black.displayName)
        )
    }

    fun makeBlacklistExistReplyMsg(chatId: Long, replyType: String, type: String): SendMessage {
        return SendMessage(
            chatId,
            replyService.messages[replyType]!!.replace("\\{type}".toRegex(), type)
        )
    }

    fun makeRemoveRecordReplyMsg(chatId: Long, manager: String, recordTitle: String): SendMessage {
        return SendMessage(
            chatId,
            replyService.messages["remove-record-manager"]!!
                .replace("\\{manager\\}".toRegex(), manager)
                .replace("\\{record\\}".toRegex(), recordTitle)
        )
    }

    fun makeRemoveRecordReplyMsg(chatId: Long, recordTitle: String): SendMessage {
        return SendMessage(
            chatId,
            replyService.messages["remove-record-user"]!!
                .replace("\\{record\\}".toRegex(), recordTitle)
        )
    }

    fun makeExceptionMsg(chatId: Long, e: Exception): SendMessage {
        return when (e) {
            is MismatchException -> SendMessage(chatId, e.message)
            else -> SendMessage(chatId, "未知错误")
        }
    }

    fun makeBanReplyMsg(
        chatId: Long,
        replyType: String,
        banChatId: String
    ): SendMessage {
        return SendMessage(
            chatId,
            replyService.messages[replyType]!! .replace("\\{chat-id\\}".toRegex(), banChatId)
        )
    }

    private fun makeReplyKeyboardMarkup(): ReplyKeyboardMarkup {
        // 每行countInRow数量个按钮
        val countInRow = 3
        // 将多个类型按照countInRow拆分为多行
        var counter = 0
        val rows = mutableListOf<Array<String>>()
        while (counter < classificationService.classifications.size) {
            var endOfIndex = counter + countInRow
            endOfIndex = if (endOfIndex <= classificationService.classifications.size) endOfIndex else classificationService.classifications.size
            val row = classificationService.classifications.copyOfRange(counter, endOfIndex)
            counter += countInRow
            rows.add(row)
        }
        // 制作键盘
        val keyboard = ReplyKeyboardMarkup(*rows.toTypedArray())
        keyboard.oneTimeKeyboard(false)
        keyboard.resizeKeyboard(true)
        keyboard.selective(true)
        return keyboard
    }
}


//@Suppress("NOTHING_TO_INLINE")
object MessageFactories {
    inline val bot get() = contextGlobal.botCurrent
    inline val keywords get() = contextGlobal.botCurrent.direct
    inline val api:BotApiProvider get() = TODO()

}