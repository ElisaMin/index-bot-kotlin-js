package com.tgse.index.new.services

import com.tgse.index.new.handle.Enrol

sealed interface RecordPreCheckResult {
    data class Failed(
        val reason: String,
        val hasExisted: Boolean = false,
        val isInservicing: Boolean = false,
        val userUnlocktime: Long? = 0,
    ) : RecordPreCheckResult
    data class Success(
        val enrol: Enrol,
    ) : RecordPreCheckResult
}
val RecordPreCheckResult.reason get() = (this as? RecordPreCheckResult.Failed)?.reason
val RecordPreCheckResult.enrol get() = (this as? RecordPreCheckResult.Success)?.enrol
object TelegramService {
    fun Enrol.checkLink(): RecordPreCheckResult {
        TODO()
    }
}