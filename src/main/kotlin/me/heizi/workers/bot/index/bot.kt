package me.heizi.workers.bot.index

import com.cloudflare.workers.types.TextEncoder
import com.cloudflare.workers.types.crypto
import com.cloudflare.workers.types.fetch
import com.github.kotlintelegrambot.entities.ChatAction
import com.github.kotlintelegrambot.network.Call
import com.github.kotlintelegrambot.network.Response
import com.github.kotlintelegrambot.network.SendChatAction
import kotlinx.coroutines.await
import org.khronos.webgl.Uint8Array
import org.khronos.webgl.get
import org.w3c.fetch.RequestInit

class TelegramApiException(override val message:String):Exception(message)
class WebRequestException(override val cause: Throwable):Exception(cause)

value class BotApiProvider private constructor(
    val wrapper: BotRequestProvider,
) {
    suspend fun <T> execute(call:Call<Response<T>>):T = wrapper.post(
        path =  call::class.js.name.let {
            // firstCharToLowerCase
            it[0].lowercase() + it.substring(1)
        },
        params = call
    ) as T

    suspend fun chatAction(chatId:dynamic, action: ChatAction=ChatAction.TYPING) = execute(
        SendChatAction(chatId,action)
    )
}

value class BotRequestProvider private constructor (
    private val url:String,
) {
    private suspend inline fun make(
//        isPost:Boolean,
        path:String,
        params:dynamic,
    ):dynamic {
//        var suf = path
//        if (isPost) {
//
//        }
        val resp = runCatching {
            fetch(
                "${url}${path}", RequestInit(
                    method =
//                    if (isPost) "POST" else
                        "GET"
                    ,
                    body = params
                )
            ).await()
        }.onFailure(::WebRequestException).getOrThrow()
        val json = resp.json().await().asDynamic()
        if (json?.ok as? Boolean? != true   || resp.status.asDynamic() != 200) {
//            json.ok = undefined
            json.description = json.description ?: resp.statusText
            json.code = resp.status
            //json.api = path.replace(/[A-Z]/g,(s)=>` ${s.toLowerCase()}`)
            //              .replace(/^\//,"")
            //            console.error(json)
            json.api = path.replace(Regex("[A-Z]")) { " ${it.value.lowercase()}" }.replace(Regex("^/"),"")
            throw TelegramApiException("""${json.api} fetch ${json.code} cause: ${json.description}""")
        }
        return json
    }
    suspend fun post(
        path:String,
        params:dynamic,
    ) = make(path,params)
}

interface BotConfig {
    val owner:Long
    val token:String
    val salt:String
    val hash:String?
    val allowedUpdates:Array<String>?
    val direct:Array<String>?
    companion object {
        val defaultDirect:Array<String> = arrayOf("NSFW","Programming","Anime","Game","Chat","Other")
    }
}

data class BotConfiguration(
    override val owner: Long,
    override val token: String,
    override val hash: String,
    override val salt: String,
    override val allowedUpdates: Array<String> = emptyArray(),
    override val direct: Array<String> = BotConfig.defaultDirect,
): BotConfig {
    init {
        require(owner>0) { "owner must be positive" }
        require(token.isNotEmpty()) { "token must not be empty" }
        require(salt.isNotEmpty()) { "salt must not be empty" }
        require(hash.length>32) { "hash must not be empty" }
    }
}

suspend fun BotConfig.toHashed(): BotConfiguration {
    val hash = hash?.takeIf { it.length>32  } ?: hash(owner,token,salt)
    return BotConfiguration(owner,token,hash,salt,
        allowedUpdates ?: emptyArray(),
        direct?.takeIf { it.isNotEmpty() } ?: BotConfig.defaultDirect
    )
}

private suspend fun hash(owner: Long,token: String,salt: String) = TextEncoder().encode("${owner}:${token}:${salt}").let {
    val array = crypto.subtle.digest("SHA-256",it).await().let(::Uint8Array)
    buildString {
        for (i in 0 until array.length) {
            append(array[i].toString(16).padStart(2,'0'))
        }
    }
}
