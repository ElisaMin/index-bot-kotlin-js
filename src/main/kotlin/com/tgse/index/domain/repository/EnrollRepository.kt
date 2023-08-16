package com.tgse.index.domain.repository

import com.pengrad.telegrambot.model.User
import com.tgse.index.domain.service.EnrollService

interface EnrollRepository {
    fun searchEnrolls(user: User, from: Int, size: Int): Pair<MutableList<EnrollService.Enroll>, Long>

    fun getEnroll(uuid: String): EnrollService.Enroll?
    fun deleteEnroll(uuid: String)
    fun addEnroll(enroll: EnrollService.Enroll): Boolean
    fun updateEnroll(enroll: EnrollService.Enroll): Boolean

    fun getSubmittedEnroll(username: String): EnrollService.Enroll?
    fun getSubmittedEnroll(chatId: Long): EnrollService.Enroll?
}