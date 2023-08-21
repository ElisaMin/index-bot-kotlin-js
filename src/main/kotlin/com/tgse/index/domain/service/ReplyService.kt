package com.tgse.index.domain.service

import com.tgse.index.domain.repository.ReplyRepository


class ReplyService(
    private val replyRepository: ReplyRepository
) {

    val messages: Map<String, String>
        get() = replyRepository.messages

}