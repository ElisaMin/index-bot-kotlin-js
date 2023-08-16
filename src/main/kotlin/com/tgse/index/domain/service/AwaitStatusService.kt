package com.tgse.index.domain.service

import com.tgse.index.domain.repository.AwaitStatusRepository
import com.tgse.index.infrastructure.provider.BotProvider
import org.springframework.stereotype.Service

@Service
class AwaitStatusService(
    private val awaitStatusRepository: AwaitStatusRepository,
    private val botProvider: BotProvider
) {

    data class Await(val messageId: Int, val callbackData: String)

    /**
     * 设置状态
     */
    fun setAwaitStatus(chatId: Long, await: Await) {
        awaitStatusRepository.setAwaitStatus(chatId, await)
    }

    /**
     * 获取状态
     */
    fun getAwaitStatus(chatId: Long): Await? {
        return awaitStatusRepository.getAwaitStatus(chatId)
    }

    /**
     * 状态处理完毕
     */
    fun applyAwaitStatus(chatId: Long) {
        val chatAwaitStatus = awaitStatusRepository.getAwaitStatus(chatId)
        if (chatAwaitStatus != null) {
            botProvider.sendDeleteMessage(chatId, chatAwaitStatus.messageId)
            awaitStatusRepository.clearAwaitStatus(chatId)
        }
    }

    /**
     * 取消状态
     */
    fun clearAwaitStatus(chatId: Long) {
        awaitStatusRepository.clearAwaitStatus(chatId)
    }

}