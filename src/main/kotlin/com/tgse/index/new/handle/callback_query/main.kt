package com.tgse.index.new.handle.callback_query

import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.network.EditMessageReplyMarkup
import com.github.kotlintelegrambot.network.EditMessageText
import com.github.kotlintelegrambot.network.SendMessage
import com.tgse.index.area.msgFactory.MessageFactories
import com.tgse.index.new.*
import com.tgse.index.new.handle.*
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import me.heizi.workers.bot.index.CustomReplies
import me.heizi.workers.bot.index.contextGlobal
import kotlin.js.Date

object CallbackKeys {
    //header
    const val enrol = "nrl"
    const val page = "p"
    const val updateCategory = "ctg"

    //methods
//    const val update = "u"
    const val requestChange = "r"
    const val remove = "c"
    fun requestChangeEnrollCallbackData(field:String,uuid:String) = "$enrol/$requestChange/$field#$uuid"
    @Suppress("NOTHING_TO_INLINE")
    inline fun Enrol.requestChangeEnrollCallbackData(field:String) = requestChangeEnrollCallbackData(field,uuid)

//    const val remove = "c"
}
suspend fun UpdateHandlerScope.handleCallback() = with(CallbackKeys) keys@{
    enrol isaCallbackFor {
        all("group") {
            anserCallback()
            next(requestChange) {
                val field = next()?:return@next
                val reply = when(field) {
                    "title" -> CustomReplies::updateTitle
                    "detail" -> CustomReplies::updateAbout //description
                    "link" -> {
                        if (type != "group") CustomReplies::updateLink
                        else CustomReplies::updateLinkGroup
                    }
                    "tags" -> CustomReplies::updateTags
                    else -> null
                }
                if (reply!=null) {
                    // todo save await data
                    reply.send()
                    return@next
                }
                when(field) {
                    "category" -> {
                        val msg = CustomReplies {
                            CustomReplies::updateCategory
                        }
                        val keyboard = MessageFactories.directInlineKeyboardMarkup(
                            queryHeader="${this@keys.enrol}/${requestChange}/category",
                        )
                        val forSend = SendMessage(chatId,msg, reply_markup=keyboard, disable_web_page_preview = true, parse_mode = "HTML")
                        api.execute(forSend)
                    }
                    remove -> with(enrol!!) {
                        when(next()) {
                            "n" -> {
                                //取消
//                                api.execute(EditMessageReplyMarkup(chatId!!,messageId))
                            }
                            "y" -> {
                                // todo delete
                            }
                            else -> {
                                //确定 ？
                                api.execute(SendMessage(chatId!!,"确定删除吗？", reply_markup = InlineKeyboardMarkup(
                                    listOf(
                                        listOf(
                                            InlineKeyboardButton.CallbackData("确定",requestChangeEnrollCallbackData(remove)),
                                            //                                        InlineKeyboardButton.CallbackData("取消",requestChangeEnrollCallbackData("cancel"))
                                        )
                                    )
                                )))
                            }
                        }
                    }
                }
            }
        }

    }
    updateCategory isaCallbackFor {
        all {
            next(requestChange) {
                val category = param()!!
                var enrol = enrol?:return@next
                enrol = enrol.copy(category = category)
                submitEnrol(enrol, category=true)
            }
        }
    }
    enrol isReplyFor {
        all("group") {
            if(isReplyTimeoutOrHasEdit()) {
            }
            next(requestChange) {
                updateEnrol()
            }
        }
        disableRest()
    }
    page isaCallbackFor {
    }
}
context(ReplyForUpdateContext)
suspend fun ReplyScope.updateEnrol() {
    var enrol = enrol?:return
    val reply = messageReplyTo.trim()
    when(next()) {
        "title" -> {
            enrol = enrol.copy(title = reply)
        }
        "detail" -> {
            enrol = enrol.copy(description = reply)
        }
        "tags" -> {
            val tags = reply.tags()
            enrol = enrol.copy(tags = tags)
        }
    }
    submitEnrol(enrol)
//    val failed:String? = enrol.checkFailedReason()
//    if (failed!=null) {
//        updateTimeout()
//        failed.send()
//    } else {
//        anserUpdateRequest()
//    }
}

suspend fun ReplyScope.isReplyTimeoutOrHasEdit():Boolean {
    TODO()
}
suspend fun FunctionContext.updateEnrolCallbackMessage(
    editMessageId:Long?,
    editing: Boolean = true,
    forReviewers:Boolean = false,
    reopen: Boolean = false,
    block:suspend ()->Enrol
) {
    val messageId = contextGlobal.scope.async {
        editMessageId ?: CustomReplies::await.send().messageId!!
    }
    val now = Date.now()
    val enrol = block()
    val editMsg = buildTelegramMessage(chatId,-1) { with(enrol) {
        line(subtitle("标题",link(title,if (this.linkableName != null) "https://t.me/$linkableName" else joinLink!!)))
        line(subtitle("标签",tags?.takeIf { it.isNotEmpty() }?.joinToString(" ") ?: "暂无"))
        line(subtitle("分类",category ?: "暂无"))
        line(subtitle("简介",description?.run { replace("<", "&lt;").replace(">", "&gt;") } ?: "暂无"))
        if (forReviewers) {
            line(subtitle("提交者", creatorFullname)+" | "+subtitle("ID",code(creatorUserId.toString())))
        }
        if (editing) with(CallbackKeys) {// keyboard
            val dir = listOf("链接" to "link","标题" to "title","简介" to "detail","标签" to "tags","分类" to "category")
                .map { (editTitle,flied)->
                    InlineKeyboardButton.CallbackData("✍更新$editTitle",requestChangeEnrollCallbackData(flied))
                }.toMutableList()
            if (reopen) buildList {
                add(listOf(dir.removeFirst()))
                addAll(dir.chunked(2))
                add(listOf(InlineKeyboardButton.CallbackData("🗑移除收录",requestChangeEnrollCallbackData(remove))))
            } else {
                dir.removeFirst()
                if (forReviewers) { Pair("通过" to "pass","回绝" to "reject") } else { Pair("提交" to "submit","取消" to remove) }.let {(resolve,reject) ->
                    buildList {
                        addAll(dir.chunked(2))
                        add(listOf(InlineKeyboardButton.CallbackData("✅${resolve.first}",requestChangeEnrollCallbackData(resolve.second))))
                        add(listOf(InlineKeyboardButton.CallbackData("❎$reject",requestChangeEnrollCallbackData(reject.second))))
                    }
                }
            }.let {
                keyboard = InlineKeyboardMarkup(it)
            }
        } else {
            if (forReviewers)
                line(subtitle("审核者", reviewerUsername!!))
            line(subtitle("审核结果",
                if ((this is TempEnrol && isPassed) || this is RecordEnrol)
                    "通过" else del("未通过")
            ))
        }
    } }
    val msgId = messageId.await()
    if (editMessageId == null) {
        TODO("save to database")
    }
    Date.now().let {
        //wait for 300ms
        if (it-now<300) {
            val sleep = 300-(it-now)
            delay(sleep.toLong())
        }
    }
    api.execute(editMsg.copy(message_id = msgId))
}
//@Suppress("NAME_SHADOWING")
suspend fun submitEnrolUnwrap(
    enrol:Enrol,
    functionContext: FunctionContext,
    noticeMsgId:Long,
    noticeMsgContent:String,
    category:String?=null,
    noticeMsgHasKeyboard:Boolean = category != null,
    fromApprove:Boolean = false
) = with(functionContext) {
    // timeout is after 15 minutes
//    val timeout = noticeMsgCreateDate+15*60*1000
//    if (hasEdit||Date.now()>timeout) {
//        val reply = CustomReplies::awaitFailed.value
//        SendMessage(chatId.toString(),reply, reply_to_message_id = noticeMsgId)
//        return
//    }
    enrol.checkFailedReason()?.let { reason ->
        //fixme: updateTimeout()
        db.updateAwaitTimeout(chatId,noticeMsgId)
        reason.send()
        return
    }
    //fixme: save to database
    updateEnrolCallbackMessage(
        forReviewers = fromApprove,
    ) {
        val editText = category?.let { category ->
            CustomReplies::updateCategorySuccess.value.replace("{{category}}",category)
        } ?: "$noticeMsgContent (已失效) "
        //fixme: js parallel
        api.execute(EditMessageText(chatId,noticeMsgId, text = editText))
        if (noticeMsgHasKeyboard)
            api.execute(EditMessageReplyMarkup(chatId,noticeMsgId, reply_markup = null))
        enrol
    }
    // cleanup keyboard mark of last enrol request and edit notice as 失效

    enrol

    // send enrol

    enrol.toMessage(
        fromApprove = fromApprove,
    )


}
suspend fun Enrol.checkFailedReason(checkLink: Boolean =false):String? {
    TODO()
}