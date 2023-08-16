package com.tgse.index.area.msgFactory

import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.request.InlineKeyboardButton
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.request.EditMessageText
import com.pengrad.telegrambot.request.SendMessage
import com.tgse.index.infrastructure.provider.BotProvider
import com.tgse.index.domain.service.EnrollService
import com.tgse.index.domain.service.RecordService
import com.tgse.index.domain.service.ReplyService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MineMsgFactory(
    override val botProvider: BotProvider,
    override val replyService: ReplyService,
    private val recordService: RecordService,
    private val enrollService: EnrollService,
    @Value("\${secretary.list.size}")
    private val perPageSize: Int
) : BaseMsgFactory(replyService, botProvider) {

    fun makeListFirstPageMsg(user: User): SendMessage {
        val (detail, keyboard) =
            makeListDetailAndKeyboard(user, 1) ?: Pair(replyService.messages["empty"], InlineKeyboardMarkup())
        return SendMessage(user.id(), detail)
            .parseMode(ParseMode.HTML).disableWebPagePreview(true).replyMarkup(keyboard)
    }

    fun makeListNextPageMsg(user: User, messageId: Int, pageIndex: Int): EditMessageText {
        val (detail, keyboard) =
            makeListDetailAndKeyboard(user, pageIndex) ?: Pair(replyService.messages["empty"], InlineKeyboardMarkup())
        return EditMessageText(user.id().toLong(), messageId, detail)
            .parseMode(ParseMode.HTML).disableWebPagePreview(true).replyMarkup(keyboard)
    }

    private fun makeListDetailAndKeyboard(
        user: User,
        pageIndex: Int
    ): Pair<String, InlineKeyboardMarkup>? {
        val range = IntRange(((pageIndex - 1) * perPageSize), pageIndex * perPageSize)
        val (records, enrolls, totalCount) = searchForMine(user, range.first)
        if (totalCount == 0L) return null
        val sb = StringBuffer()
        records.forEach {
            val item = generateRecordItem(it)
            sb.append(item)
        }
        enrolls.forEach {
            val item = generateEnrollItem(it)
            sb.append(item)
        }
        val keyboard = makeMinePageKeyboardMarkup(totalCount, pageIndex, perPageSize, range)
        return Pair(sb.toString(), keyboard)
    }

    private fun searchForMine(
        user: User,
        from: Int
    ): Triple<MutableList<RecordService.Record>, MutableList<EnrollService.Enroll>, Long> {
        val (records, recordTotalCount) = recordService.searchRecordsByCreator(user, from, perPageSize)
        val enrollsFrom = if (from > recordTotalCount) from - recordTotalCount.toInt() else 0
        val (enrolls, enrollTotalCount) = enrollService.searchEnrolls(user, enrollsFrom, perPageSize - records.size)
        val totalCount = enrollTotalCount + recordTotalCount
        return Triple(records, enrolls, totalCount)
    }

    private fun makeMinePageKeyboardMarkup(
        totalCount: Long,
        pageIndex: Int,
        perPageSize: Int,
        range: IntRange
    ): InlineKeyboardMarkup {
        return when {
            totalCount > perPageSize && range.first == 0 ->
                InlineKeyboardMarkup(
                    arrayOf(
                        InlineKeyboardButton("下一页").callbackData("mine:${pageIndex + 1}"),
                    )
                )
            totalCount > perPageSize && range.first != 0 && range.last < totalCount ->
                InlineKeyboardMarkup(
                    arrayOf(
                        InlineKeyboardButton("上一页").callbackData("mine:${pageIndex - 1}"),
                        InlineKeyboardButton("下一页").callbackData("mine:${pageIndex + 1}"),
                    )
                )
            totalCount > perPageSize && range.last >= totalCount ->
                InlineKeyboardMarkup(
                    arrayOf(
                        InlineKeyboardButton("上一页").callbackData("mine:${pageIndex - 1}"),
                    )
                )
            else -> InlineKeyboardMarkup()
        }
    }

}