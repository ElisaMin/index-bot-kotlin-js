package com.tgse.index.domain.service

import com.tgse.index.domain.repository.BlackListRepository
import org.springframework.stereotype.Service

/**
 * 收录黑名单
 *
 * 无奈之举
 * 部分用户频繁恶意提交收录申请，给审核团队造成不必要的麻烦
 * todo: 不应由 elasticsearch 实现
 */
@Service
class BlackListService(
    private val blackListRepository: BlackListRepository
) {

    enum class BlackType {
        Record,
        User
    }

    data class Black(
        val uuid: String,
        val type: BlackType,
        val displayName: String,
        val level: Int,
        val chatId: Long?,
        val username: String?,
        val unfreezeTime: Long
    )

    fun get(username: String): Black? {
        return blackListRepository.get(username)
    }

    fun get(chatId: Long): Black? {
        return blackListRepository.get(chatId)
    }

    fun add(black: Black): Boolean {
        return blackListRepository.add(black)
    }

    fun update(black: Black): Boolean {
        return blackListRepository.update(black)
    }

    fun delete(uuid: String) {
        return blackListRepository.delete(uuid)
    }

}