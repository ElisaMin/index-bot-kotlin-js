package com.tgse.index.new.services

import me.heizi.workers.bot.index.contextGlobal

//todo
fun Rejecting.checkUnservicing(chat_d: Long) = false
//todo
fun Rejecting.isEnrollBlock(id:String) = false
//todo
fun Rejecting.isUserFreezed(chat_id: Long) = false
data object Rejecting {
    private inline val db get() = contextGlobal.db
//    inline val api get() = contextGlobal.api
}


/**
 * 具绝请求数据类型
 *
 * * 冻结/禁言用户
 *   - 针对提交者用户，自动解禁。
 * * 具绝收录
 *   - 针对单个收录。
 * * 具绝服务
 *   - 针对用户。
 *
 * From database and covert as a Kotlin object
 */
sealed interface Rejects {
    val uuid: String
    val display_name: String
    val create_time: Long
    val chat_id: Long
    val type_id : Int
    val type get() = types[type_id]

    companion object {
        val types = arrayOf("ban","freeze","rejected")

    }

    data class UnlockableUser(
        override val uuid: String,
        override val display_name: String,
        override val chat_id: Long,
        override val create_time: Long,
        val unlock_time: Long,
        val level: Int = 0,
    ) : Rejects {
        override val type_id: Int = 1
    }

    data class Unservicing(
        override val uuid: String,
        override val chat_id: Long,
        override val create_time: Long,
        override val display_name: String,
    ) : Rejects {
        override val type_id: Int = 0
    }

    data class BlockedEnroll(
        override val uuid: String,
        override val display_name: String,
        override val chat_id: Long,
        override val create_time: Long,
        val enroll: String
    ) : Rejects {
        override val type_id: Int = 2
    }

    data class DTO(
        override val uuid: String,
        override val display_name: String,
        override val create_time: Long,
        override val chat_id: Long,
        override val type_id:Int,
        val data:String?
    ): Rejects




}

fun checkBlocked(chatId: dynamic,userId: dynamic) = true
