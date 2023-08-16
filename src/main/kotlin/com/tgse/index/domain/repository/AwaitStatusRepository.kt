package com.tgse.index.domain.repository

import com.tgse.index.domain.service.AwaitStatusService

interface AwaitStatusRepository {

    /**
     * 设置状态
     */
    fun setAwaitStatus(chatId: Long, await: AwaitStatusService.Await)

    /**
     * 获取状态
     */
    fun getAwaitStatus(chatId: Long): AwaitStatusService.Await?

    /**
     * 清除状态
     */
    fun clearAwaitStatus(chatId: Long)

}