package com.tgse.index.new.handle.callback_query

import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.ReplyKeyboardRemove
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.network.EditMessageReplyMarkup
import com.github.kotlintelegrambot.network.EditMessageText
import com.github.kotlintelegrambot.network.SendMessage
import com.tgse.index.area.msgFactory.MessageFactories
import com.tgse.index.new.*
import com.tgse.index.new.handle.*
import com.tgse.index.new.services.RecordPreCheckResult
import com.tgse.index.new.services.TelegramService
import com.tgse.index.new.services.enrol
import com.tgse.index.new.services.reason
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import me.heizi.workers.bot.index.CustomReplies
import me.heizi.workers.bot.index.contextGlobal
import kotlin.js.Date


object db {
    suspend fun updateLastMessageId(uuid: String, it: Long) {
        TODO()
    }
    suspend fun updateAwaitTimeout(chatId: Long, noticeMsgId: Long) {
        TODO()
    }
    suspend fun findEnrolByUUID(uuid: String): Enrol? {
        TODO()
    }

    fun categories(): Array<String> {
        TODO("Not yet implemented")
    }

    fun getTimeout(chatId: Long?, messageId: Long): Long? {
        TODO("Not yet implemented")
    }

    suspend fun updateEnrol(enrol: Enrol) {
        TODO("Not yet implemented")
    }

}
interface AwaitInfo {
    val chatId:Long
    val messageId:Long
    val callbackData:String
    val timeout:Long?
}

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
            answerCallback()
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
                    "pass" -> {
                        // todo pass
                    }
                    "reject" -> {
                        // todo reject
                    }
                    "submit" -> {
                        enrol!!
                    }
                }
            }
        }
    }
    updateCategory isaCallbackFor {
        all {
            next(requestChange) {
                answerCallback()
                val category = param()!!
                var enrol = enrol?:return@next
                enrol = enrol.copy(category = category)
                saveUpdatedEnrol(enrol,messageId,noticeMsgContent = null,category = category)
            }
        }
    }
    enrol isReplyFor {
        all("group") {
            if(isReplyTimeoutOrHasEdit()) {
                CustomReplies::awaitFailed.send()
                return@all
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
    var checkLink = false
    when(next()) {
        "link" -> {
            checkLink = true
            enrol = enrol.copy(linkableName = reply)
        }
        "title" -> {
            enrol = enrol.copy(title = reply)
        }
        "detail" -> {
            enrol = enrol.copy(description = reply)
        }
        "tags" -> {
            val tags = reply.tags()
            enrol = enrol.copy(tags = tags,)
        }
    }
    saveUpdatedEnrol(enrol,checkLink = checkLink)
}

private fun String.tags(): Collection<String>? {
    TODO()
}

private fun Enrol.copy(
    title: String = this.title,
    linkableName: String = this.linkableName,
    description: String? = this.description,
    category: String? = this.category,
    tags: Collection<String>? = this.tags,
    reviewerFullname: String? = this.reviewerFullname,
    reviewerUsername: String? = this.reviewerUsername,
    reviewerId:Long? = this.reviewerId,
    lastUpdate: Long = Date.now().toLong(),
    isPassed: Boolean = (this as? TempEnrol)?.isPassed ?: false,
    hasSent: Boolean = (this as? TempEnrol)?.hasSent ?: true
): Enrol = TODO()

context(ReplyForUpdateContext)
fun ReplyScope.isReplyTimeoutOrHasEdit():Boolean {
    db.getTimeout(chatId,idReplyTo)?.let { timeout ->
        if (timeout<Date.now()) {
            return true
        }
    }
    return hasEdit
}

context(ReplyForUpdateContext)
suspend inline fun ReplyScope.saveUpdatedEnrol(enrol: Enrol,checkLink:Boolean = false) = saveUpdatedEnrol(
    enrol,
    idReplyTo,
    messageReplyTo,
    isForReviewer = isForReviewers,
    category = null,
    checkLink = checkLink
)

//@Suppress("NAME_SHADOWING")
suspend fun FunctionContext.saveUpdatedEnrol(
    _enrol:Enrol,
    noticeMsgId: Long,
    noticeMsgContent: String?,
    isForReviewer: Boolean = false,
    category: String?=null,
    checkLink:Boolean = false
) {
    var enrol = _enrol
    if (noticeMsgContent!=null)
    enrol.checkUpdateFailedReason(checkLink).let { result ->
        result.reason?.let { reason ->
            db.updateAwaitTimeout(chatId,noticeMsgId)
            reason.send()
            return
        }
        enrol = result.enrol!!
    }
    enrol = enrol.reviewable()
    db.updateEnrol(enrol)
    updateEnrolCallbackMessage(null, forReviewers = isForReviewer) {
        when {
            category!=null -> {
                api.execute(EditMessageReplyMarkup(chatId,noticeMsgId, reply_markup = ReplyKeyboardRemove()))
                CustomReplies::updateCategorySuccess.value.replace("{{category}}",category)
            }
            else -> "${noticeMsgContent!!} (已失效) "

        }.let {
            api.execute(EditMessageText(chatId,noticeMsgId, text = it))
        }
        enrol
    }
}

private fun Enrol.reviewable(): Enrol = copy(
    reviewerUsername = null,
    reviewerFullname = null,
    reviewerId = null,
    isPassed = false,
    hasSent = false
)

suspend fun Enrol.checkUpdateFailedReason(checkLink: Boolean = false):RecordPreCheckResult {
    var new = this
    if (checkLink) {
        val fromDB = db.findEnrolByUUID(uuid) ?: return "收录已失效".recheckResult()
        if (new.linkableName != fromDB.linkableName) {
            val pure = with(TelegramService){ new.checkLink() }.let {
                it.enrol ?: return (it.reason ?: "错误信息：114514").recheckResult()
            }
            if (pure.type!=fromDB.type) return "收录类型不匹配".recheckResult()
            new = pure
        }
    }
    if (new.title.length>26) return "标题太长".recheckResult()
    if ((new.description?.length ?: 0) > 512) return "简介太长".recheckResult()
    if (new.category !in db.categories()) return "分类不存在".recheckResult()
    return RecordPreCheckResult.Success(new)
}


@Suppress("NOTHING_TO_INLINE")
private inline fun String.recheckResult() = RecordPreCheckResult.Failed(this)

fun Enrol.buildReplyMessage(
    chatId: Long = -1,
    editMessageId: Long = -1,
    editing: Boolean = true,
    forReviewers: Boolean = false,
    reopen: Boolean = false,
) = buildTelegramMessage(chatId,editMessageId) {
    line(subtitle("标题",link(title,link)))
    line(subtitle("标签",tags?.takeIf { it.isNotEmpty() }?.joinToString(" ") ?: "暂无"))
    line(subtitle("分类",category ?: "暂无"))
    line(subtitle("简介",description?.run { replace("<", "&lt;").replace(">", "&gt;") } ?: "暂无"))
    if (forReviewers) {
        line(subtitle("提交者", creatorFullname)+" | "+subtitle("ID",code(creatorUserId.toString())))
    }
    if (editing) with(CallbackKeys) {// keyboard
        listOf("链接" to "link","标题" to "title","简介" to "detail","标签" to "tags","分类" to "category")
            .map { (editTitle,flied)->
                InlineKeyboardButton.CallbackData("✍更新$editTitle",requestChangeEnrollCallbackData(flied))
            }.toMutableList().let {dir ->
                if (reopen) buildList {
                    add(listOf(dir.removeFirst()))
                    addAll(dir.chunked(2))
                    add(listOf(InlineKeyboardButton.CallbackData("🗑移除收录",requestChangeEnrollCallbackData(remove))))
                }
                else {
                    dir.removeFirst()
                    if (forReviewers) { Pair("通过" to "pass","回绝" to "reject") } else { Pair("提交" to "submit","取消" to remove) }
                        .let { (resolve,reject) ->
                            dir+= InlineKeyboardButton.CallbackData("✅${resolve.first}",requestChangeEnrollCallbackData(resolve.second))
                            dir+= InlineKeyboardButton.CallbackData("❎${reject.first}",requestChangeEnrollCallbackData(reject.second))
                        }
                    dir.chunked(2)
                }
            }.let {
                keyboard = InlineKeyboardMarkup(it)
            }
    } else {
        if (forReviewers) line(subtitle("审核者", reviewerUsername!!))
        line(subtitle("审核结果",
            if ((this@buildReplyMessage is TempEnrol && isPassed) || this@buildReplyMessage is RecordEnrol)
                "通过" else del("未通过")
        ))
    }
}


suspend fun FunctionContext.updateEnrolCallbackMessage(
    editMessageId:Long?,
    forReviewers:Boolean = false,
    block:suspend ()->Enrol
) {
    val messageId = contextGlobal.scope.async {
        editMessageId ?: CustomReplies::await.send().messageId!!
    }
    val now = Date.now()
    val enrol = block()
    val editMsg = enrol.buildReplyMessage(
        chatId = chatId,
        editMessageId = -1,
        editing = true,
        forReviewers = forReviewers,
        reopen = false
    )
    val msgId = messageId.await()
    if (editMessageId == null) {
        (enrol as? TempEnrol)?.lastMessageId?.let {
            api.execute(EditMessageReplyMarkup(chatId,it))
            db.updateLastMessageId(enrol.uuid,it)
        }
    }
    Date.now().let {
        //wait for 50ms
        if (it-now<50) {
            val sleep = 50-(it-now)
            delay(sleep.toLong())
        }
    }
     editMsg.let {
         it.asDynamic().message_id = msgId
     }
    api.execute(editMsg)
}
