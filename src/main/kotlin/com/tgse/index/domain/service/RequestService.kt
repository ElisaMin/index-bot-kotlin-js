package com.tgse.index.domain.service

import com.github.kotlintelegrambot.entities.Chat
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.entities.User
import com.tgse.index.domain.repository.BanListRepository
import com.tgse.index.infrastructure.provider.BotProvider

/**
 * 信息来源分水岭
 * 区分 群组、私聊、管理 信息来源
 */
class RequestService(
    private val banListRepository: BanListRepository,
    private val botProvider: BotProvider,
    @Value("\${group.approve.id}")
    private val approveGroupChatId: Long
) {

    open class BotRequest(
        open val chatId: Long?,
        open val chatType: Chat.Type?,
        open val messageId: Int?,
        open val update: Update
    )

    class BotPrivateRequest(
        override val chatId: Long,
        override val messageId: Int?,
        override val update: Update
    ) : BotRequest(
        chatId,
        Chat.Type.Private,
        messageId,
        update
    )

    class BotGroupRequest(
        override val chatId: Long,
        override val messageId: Int?,
        override val update: Update
    ) : BotRequest(
        chatId,
        Chat.Type.group,
        messageId,
        update
    )

    class BotApproveRequest(
        override val chatId: Long,
        override val messageId: Int?,
        override val update: Update
    ) : BotRequest(
        chatId,
        Chat.Type.group,
        messageId,
        update
    )

    private val logger = LoggerFactory.getLogger(this::class.java)
    private val requestSubject = BehaviorSubject.create<BotRequest>()
    val requestObservable: Observable<BotRequest> = requestSubject.distinct()
    val feedbackSubject = BehaviorSubject.create<Triple<RecordService.Record, User, String>>()
    val feedbackObservable: Observable<Triple<RecordService.Record, User, String>> = feedbackSubject.distinct()

    init {
        subscribeUpdate()
    }

    private fun subscribeUpdate() {
        botProvider.updateObservable.subscribe(
            { update ->
                val request = makeBotRequest(update) ?: return@subscribe
                request.chatId?.apply {
                    banListRepository.get(this)?.apply {
                        return@subscribe
                    }
                }
                requestSubject.onNext(request)
            },
            { throwable ->
                throwable.printStackTrace()
                logger.error("Group.error")
                botProvider.sendErrorMessage(throwable)
            },
            {
                logger.error("Group.complete")
            }
        )
    }

    private fun makeBotRequest(update: Update): BotRequest? {
        // 仅处理文字信息或按钮回执
        val messageContentIsNull = update.message?.text == null
        if (messageContentIsNull && update.callbackQuery == null) return null

        // 获取概要内容
        val callbackQuery = update.callbackQuery

        val chatType = when {
            update.message == null && callbackQuery == null -> null
            update.message != null -> update.message.chat.type
            callbackQuery != null -> callbackQuery.message?.chat?.type
            else -> null
        }

        val chatId = when {
            update.message == null && callbackQuery == null -> null
            callbackQuery?.message != null -> callbackQuery.message.chat.id
            callbackQuery != null -> callbackQuery.from.id
            update.message != null -> update.message.chat.id
            else -> null
        }

        val messageId = callbackQuery?.message?.messageId

        return when (chatType) {
            Chat.Type.Private -> BotPrivateRequest(chatId!!, messageId, update)
            Chat.Type.supergroup, Chat.Type.group -> {
                if (chatId == approveGroupChatId) BotApproveRequest(chatId, messageId, update)
                else BotGroupRequest(chatId!!, messageId, update)
            }
            else -> null
        }
    }

}