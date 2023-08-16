package com.tgse.index.domain.repository

import com.tgse.index.domain.service.BanListService

interface BanListRepository {

    fun add(ban: BanListService.Ban): Boolean
    fun get(chatId: Long): BanListService.Ban?
    fun all(): Pair<Collection<BanListService.Ban>, Long>
    fun delete(uuid: String)

}