package com.tgse.index.domain.service

import com.tgse.index.domain.repository.BanListRepository
import org.springframework.stereotype.Service

/**
 * 服务黑名单
 *
 * 无奈之举
 * 针对素质极低的个别用户
 * todo: 不应由 elasticsearch 实现
 */
@Service
class BanListService(
    private val banListRepository: BanListRepository
) {

    data class Ban(
        val uuid: String,
        val chatId: Long?,
        val createTime: Long,
    )

    fun add(ban: Ban): Boolean {
        return banListRepository.add(ban)
    }

    fun get(chatId: Long): Ban? {
        return banListRepository.get(chatId)
    }

    fun all(): Pair<Collection<Ban>, Long> {
        return banListRepository.all()
    }

    fun delete(uuid: String) {
        return banListRepository.delete(uuid)
    }

}