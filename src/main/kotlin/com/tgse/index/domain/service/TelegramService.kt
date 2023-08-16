package com.tgse.index.domain.service

import com.tgse.index.domain.repository.TelegramRepository
import org.springframework.stereotype.Service

@Service
class TelegramService(
    private val telegramRepository: TelegramRepository
) {

    enum class TelegramModType {
        Channel,
        Group,
        Bot,
        Person
    }

    interface TelegramMod {
        val username: String?
        val title: String
        val description: String?
    }

    data class TelegramChannel(
        override val username: String,
        override val title: String,
        override val description: String?,
        val members: Long
    ) : TelegramMod

    data class TelegramGroup(
        val chatId: Long?,
        override val username: String?,
        val link: String?,
        override val title: String,
        override val description: String?,
        val members: Long
    ) : TelegramMod

    data class TelegramBot(
        override val username: String,
        override val title: String,
        override val description: String?
    ) : TelegramMod

    data class TelegramPerson(
        val chatId: Long?,
        override val username: String?,
        override val title: String,
        override val description: String?
    ) : TelegramMod


    /**
     * 公开群组、频道、机器人
     */
    fun getTelegramMod(username: String): TelegramMod? {
        return telegramRepository.getTelegramMod(username)
    }

    /**
     * 群组
     */
    fun getTelegramMod(id: Long): TelegramGroup? {
        return telegramRepository.getTelegramMod(id)
    }

}