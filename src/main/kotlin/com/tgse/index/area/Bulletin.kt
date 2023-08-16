package com.tgse.index.area

import com.tgse.index.area.msgFactory.BulletinMsgFactory
import com.tgse.index.domain.service.RecordService
import com.tgse.index.infrastructure.provider.BotProvider
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * 公告板
 */
@Service
class Bulletin(
    private val botProvider: BotProvider,
    private val bulletinMsgFactory: BulletinMsgFactory,
    private val recordService: RecordService,
    @Value("\${channel.bulletin.id}")
    private val bulletinChatId: Long
) {

    private val logger = LoggerFactory.getLogger(Bulletin::class.java)

    init {
        subscribeUpdateRecord()
        subscribeDeleteRecord()
    }

    /**
     * 发布公告
     */
    fun publish(record: RecordService.Record) {
        val msg = bulletinMsgFactory.makeBulletinMsg(bulletinChatId, record)
        val response = botProvider.send(msg)
        // 补充公告消息ID
        val newRecord = record.copy(bulletinMessageId = response.message().messageId())
        recordService.addRecord(newRecord)
    }

    /**
     * 同步数据-更新公告
     */
    private fun subscribeUpdateRecord() {
        recordService.updateRecordObservable.subscribe(
            { record ->
                try {
                    val msg = bulletinMsgFactory.makeBulletinMsg(bulletinChatId, record.bulletinMessageId!!, record)
                    botProvider.send(msg)
                } catch (e: Throwable) {
                    botProvider.sendErrorMessage(e)
                    e.printStackTrace()
                }
            },
            { throwable ->
                logger.error("Bulletin.subscribeUpdateRecord.error", throwable)
            },
            {
                logger.error("Bulletin.subscribeUpdateRecord.complete")
            }
        )
    }

    /**
     * 同步数据-删除公告
     */
    private fun subscribeDeleteRecord() {
        recordService.deleteRecordObservable.subscribe(
            { (record, _) ->
                try {
                    val msg = bulletinMsgFactory.makeRemovedBulletinMsg(bulletinChatId, record.bulletinMessageId!!)
                    botProvider.send(msg)
                } catch (e: Throwable) {
                    botProvider.sendErrorMessage(e)
                    e.printStackTrace()
                }
            },
            { throwable ->
                logger.error("Bulletin.subscribeDeleteRecord.error", throwable)
            },
            {
                logger.error("Bulletin.subscribeDeleteRecord.complete")
            }
        )
    }

}