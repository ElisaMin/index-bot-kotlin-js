package me.heizi.workers.bot.index

import com.cloudflare.workers.types.D1Database

external interface Env {
    val dataDB:D1Database
    val bots:Array<BotConfig>
    val webhookUrlHost:String
    val webhookPathPattern:String?
    val telegramApiUrl:String?
    val customReplies: CustomReplies?
}
value class Database(val dataDB:D1Database?) {
    inline val db get() = dataDB!!
}