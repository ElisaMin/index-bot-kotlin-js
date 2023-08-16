package com.tgse.index.domain.service

import com.tgse.index.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    data class User(

        /**
         * 用户标识，取自 telegram
         */
        val id: Long,

        /**
         * 首次使用时间
         */
        val createTime: Long,

        /**
         * 上次使用时间
         */
        val updateTime: Long

    )

    fun footprint(id: Long) {
        userRepository.footprint(id)
    }

    fun statistics(): Triple<Long, Long, Long> {
        return userRepository.statistics()
    }

}