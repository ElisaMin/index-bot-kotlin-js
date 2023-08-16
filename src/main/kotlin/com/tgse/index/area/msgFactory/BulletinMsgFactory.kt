package com.tgse.index.area.msgFactory

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.request.EditMessageText
import com.pengrad.telegrambot.request.SendMessage
import com.tgse.index.domain.service.RecordService
import com.tgse.index.domain.service.ReplyService
import com.tgse.index.infrastructure.provider.BotProvider
import org.springframework.stereotype.Component

@Component
class BulletinMsgFactory(
    override val replyService: ReplyService,
    override val botProvider: BotProvider
) : BaseMsgFactory(replyService, botProvider) {

    fun makeBulletinMsg(chatId: Long, record: RecordService.Record): SendMessage {
        val detail = makeRecordDetail(record)
        return SendMessage(chatId, detail).parseMode(ParseMode.HTML).disableWebPagePreview(true)
    }

    fun makeBulletinMsg(chatId: Long, messageId: Int, record: RecordService.Record): EditMessageText {
        val detail = makeRecordDetail(record)
        return EditMessageText(chatId, messageId, detail).parseMode(ParseMode.HTML).disableWebPagePreview(true)
    }

    fun makeRemovedBulletinMsg(chatId: Long, messageId: Int): EditMessageText {
        val text = replyService.messages["record-removed"]
        val keyboard = InlineKeyboardMarkup()
        return EditMessageText(chatId, messageId, text).replyMarkup(keyboard)
    }

}