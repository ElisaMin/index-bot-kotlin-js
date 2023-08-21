package com.tgse.index.infrastructure.provider

import com.github.kotlintelegrambot.entities.ChatAction
import com.github.kotlintelegrambot.network.*
import me.heizi.workers.bot.index.BotApiProvider

class BotProvider(
    val wrapper:BotApiProvider
) {

    val username: String by lazy {
        val request = GetMe()
        val response = this.wrapper.execute(request)
        response.result.username!!
    }

    init {
        handleUpdate()
    }

    private fun handleUpdate() {
        this.wrapper.setUpdatesListener { updates ->
            val exceptions = updates
                .map { update -> requestExecutorService.submit { updateSubject.onNext(update) } }
                .asSequence()
                .mapNotNull { future ->
                    runCatching {
                        future.get()
                    }.onFailure {
                        it.printStackTrace()
                    }.exceptionOrNull()
                }.filterIsInstance<ElasticSearchException>()
                .toList()
            if (exceptions.isNotEmpty()) {
                exceptions.forEach {
                    it.printStackTrace()
                }
                throw RuntimeException("ElasticSearch ERROR!")
            }
            UpdatesListener.CONFIRMED_UPDATES_ALL
        }
    }

    fun send(message: SendMessage): SendResponse {
        SendMessage()
        return this.wrapper.execute(message)
    }

    fun sendDeleteMessage(chatId: Long, messageId: Int): BaseResponse {
        val deleteMessage = DeleteMessage(chatId, messageId)
        return this.wrapper.execute(deleteMessage)
    }

    /**
     * 发送自毁消息
     */
    fun sendAutoDeleteMessage(message: SendMessage): BaseResponse {
        val sendResponse = send(message)
        val timer = Timer("auto-delete-message", true)
        val timerTask = object : TimerTask() {
            override fun run() {
                try {
                    val chatId = sendResponse.message().chat().id()
                    val messageId = sendResponse.message().messageId()
                    sendDeleteMessage(chatId, messageId)
                } catch (e: Throwable) {
                    // ignore
                }
            }
        }
        timer.schedule(timerTask, autoDeleteMsgCycle * 1000)
        return sendResponse
    }

    fun send(answer: AnswerCallbackQuery) = this.wrapper.execute(answer)

    fun send(message: EditMessageText)= this.wrapper.execute(message)

    fun send(message: EditMessageReplyMarkup) = this.wrapper.execute(message)

    fun sendDelay(message: EditMessageReplyMarkup, delay: Long) {
        val timer = Timer("delay-message", true)
        val timerTask = object : TimerTask() {
            override fun run() {
                try {
                    send(message)
                } catch (e: Throwable) {
                    // ignore
                }
            }
        }
        timer.schedule(timerTask, delay)
    }

    fun send(action: GetChat) = this.wrapper.execute(action)

    fun send(action: GetChatMemberCount) = this.wrapper.execute(action)

    fun send(action: GetChatAdministrators) = this.wrapper.execute(action)

    fun sendTyping(chatId: Long) {
        val chatAction = SendChatAction(chatId, ChatAction.TYPING)
        send(chatAction)
    }

    private fun send(action: SendChatAction) = this.wrapper.execute(action)

    fun sendErrorMessage(error: Throwable) {
        try {
            val msgContent = "Error:\n" + (error.message ?: error.stackTrace.copyOfRange(0, 4).joinToString("\n"))
            val errorMessage = SendMessage(botProperties.creator, msgContent)
            this.wrapper.execute(errorMessage)
        } catch (e: Throwable) {
            // ignore
        }
        if (error is ElasticSearchException)
            throw error
    }
}