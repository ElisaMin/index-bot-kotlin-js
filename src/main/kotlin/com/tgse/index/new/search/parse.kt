package com.tgse.index.new.search

import com.tgse.index.new.FunctionContext
import com.tgse.index.new.handle.Enrol
import com.tgse.index.new.handle.TelegramMessageBuilder
import com.tgse.index.new.value
import me.heizi.workers.bot.index.CustomReplies
import kotlin.math.roundToInt


context (SearchContext)
fun Enrols.buildListReplyContent() = TelegramMessageBuilder().apply {
    if (isEmpty()) {
        line(CustomReplies::empty.value)
        return@apply
    }
    if (mine) forEach {
        it.buildListItem(this, "👤")
    } else forEach {
        it.buildListItem(this)
    }
    inlineKeyboard {
        row {
            if (page>1) callbackButton("⬅️", "page ${page-1}")
            if (page<maxPage) callbackButton("➡️", "page ${page+1}")
        }
    }
}
context (SearchContext)
private fun Enrol.buildListItem(
    telegramMessageBuilder: TelegramMessageBuilder,
    icon: String = icons(type),
) = telegramMessageBuilder.apply {
    line(link("""$icon ${membersCount?.takeIf { it > 1 }?.shortCut()?:""} | $title """,commandLink))
}


interface SearchContext {
    val mine: Boolean
    val page: Int
    val maxPage: Int

    /**
     * return a link for answer search item
     *
     */
    val Enrol.commandLink:String
    fun icons(type:String) = icons[type] ?: "❓"
    companion object {
        private val icons = mapOf(
            "group" to "\uD83D\uDC65",
            "supergroup" to "\uD83D\uDC65",
            "channel" to "\uD83D\uDCE2",
            "bot" to "\uD83E\uDD16",
        )
        context(FunctionContext)
        fun get():SearchContext = TODO()
    }
}

/**
 * 数字单位 1k 1m
 */
fun Long.shortCut():String {
    var value = 0.0
    value+=this

    for(unit in arrayOf("","K","M")) {
        if (value<1000) return "$value$unit"
        value /= 1000
        //保留一个小数点
        value = (value*10).roundToInt()/10.0
    }
    return "1000M+"
}