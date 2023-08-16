package com.tgse.index.domain.repository

interface UserRepository {

    /**
     * 记录用户
     */
    fun footprint(id: Long)

    /**
     * 统计用户数据
     * 用户总量、日增、日活
     */
    fun statistics(): Triple<Long, Long, Long>

}