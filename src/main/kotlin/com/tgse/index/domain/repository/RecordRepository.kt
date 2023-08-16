package com.tgse.index.domain.repository

import com.pengrad.telegrambot.model.User
import com.tgse.index.domain.service.RecordService

interface RecordRepository {

    fun getAllRecords(from: Int, size: Int): Pair<MutableList<RecordService.Record>, Long>

    fun searchRecordsByClassification(classification: String, from: Int, size: Int): Pair<MutableList<RecordService.Record>, Long>
    fun searchRecordsByKeyword(keyword: String, from: Int, size: Int): Pair<MutableList<RecordService.Record>, Long>
    fun searchRecordsByCreator(user: User, from: Int, size: Int): Pair<MutableList<RecordService.Record>, Long>

    fun getRecordByUsername(username: String): RecordService.Record?
    fun getRecordByChatId(chatId: Long): RecordService.Record?

    fun addRecord(record: RecordService.Record): Boolean
    fun updateRecord(record: RecordService.Record)
    fun deleteRecord(uuid: String, manager: User)
    fun getRecord(uuid: String): RecordService.Record?

    fun count(): Long

}