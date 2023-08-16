package com.tgse.index.domain.repository

import com.tgse.index.domain.service.BlackListService

interface BlackListRepository {

    fun get(username: String): BlackListService.Black?
    fun get(chatId: Long): BlackListService.Black?
    fun add(black: BlackListService.Black): Boolean
    fun update(black: BlackListService.Black): Boolean
    fun delete(uuid: String)

}