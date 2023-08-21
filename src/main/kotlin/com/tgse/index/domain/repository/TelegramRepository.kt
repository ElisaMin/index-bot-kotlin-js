package com.tgse.index.domain.repository


import com.github.kotlintelegrambot.entities.User
import com.tgse.index.domain.service.TelegramService

interface TelegramRepository {

    /**
     * 公开群组、频道、机器人
     */
    fun getTelegramMod(username: String): TelegramService.TelegramMod?

    /**
     * 群组
     */
    fun getTelegramMod(id: Long): TelegramService.TelegramGroup?

}

fun User.nick(): String {
    val firstName =
        firstName
    val lastName =
        if (lastName == null) ""
        else lastName
    return "$firstName$lastName"
}