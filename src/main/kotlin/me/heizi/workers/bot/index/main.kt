package me.heizi.workers.bot.index

import com.cloudflare.workers.types.ExecutionContext
import com.cloudflare.workers.types.URL
import com.cloudflare.workers.types.crypto
import com.cloudflare.workers.types.fetch
import kotlinx.coroutines.*
import org.w3c.fetch.Request
import org.w3c.fetch.Response

suspend fun BotConfiguration.checkWebhookRequest(path:String):Response? {
    for (method in arrayOf("set", "getMe", "del", "info")) {
        if (!path.endsWith("/webhook/${method}")) continue
        var url = "${contextGlobal.telegramApiUrl}${token}"
        when(method) {
            "set" -> {
                url+= "/setWebhook?url="
                url += contextGlobal.webhookPathPattern.replace(Regex("""\(.+?\)"""), hash)
                if (allowedUpdates.isNotEmpty()) {
                    url += "&allowed_updates="
                    url += allowedUpdates.joinToString(",")
                }
            }
            "getMe" -> {
                url += "/getMe"
            }
            "del" -> {
                url += "/deleteWebhook"
            }
            "info" -> {
                url += "/getWebhookInfo"
            }
        }
        return fetch(url).await()
    }
    return null
}


suspend fun main(request: Request, env: Env, ctx: ExecutionContext?):Response? = InnerContext.scope.run {
    val botHashing = updateContextByEnv(env)
    val url = URL(request.url)
    val path = url.pathname
    val hash = let {
        val patten = contextGlobal.webhookPathPattern.toRegex()
        val match = patten.find(path) ?: return@run null
        match.groupValues[1]
    }
    val bot = botHashing.await()?.bots?.find { it.hash == hash } ?: return@run null
    if (!request.isPost) {
        return@run bot.checkWebhookRequest(path)
    }

    null
}

private val Request.isGet: Boolean
    get() {
        val method = this.asDynamic().method
        return method == "GET"
    }
private val Request.isPost: Boolean
    get() {
        val method = this.asDynamic().method
        return method == "POST"
    }
var contextGlobal = InnerContext("")
    private set

data class InnerContext(
    val webhookUrlHost:String,
    val customReplies: CustomReplies?=null,
    val bots:List<BotConfiguration> = emptyList(),
    val webhookPathPattern:String = "/bot/([a-zA-Z0-9]+)/.+",
    val telegramApiUrl:String = "https://api.telegram.org",
    val db:Database = Database(null),
    val botCurrent:BotConfiguration = crypto.randomUUID().let {
        BotConfiguration(
            owner = 1000000,
            token = it,
            salt = it,
            hash = it+it,
        )
    }
) {
    val scope get() = Companion.scope

    companion object {
        val scope = CoroutineScope(Dispatchers.Default)
    }
}

@Suppress("NOTHING_TO_INLINE")
private inline fun updateGlobalContext(context: InnerContext) {
    contextGlobal = context
}
fun updateContextByEnv(env: Env) = InnerContext.scope.run {
    val botHashing = env.bots.map {
        async {
            runCatching {
                it.toHashed()
            }.onFailure {
                console.error(it.message)
            }.getOrNull()
        }
    }
    updateGlobalContext(contextGlobal.copy(webhookUrlHost = env.webhookUrlHost))

    env.webhookPathPattern?.let {
        updateGlobalContext(contextGlobal.copy(webhookPathPattern = it))
    }
    env.telegramApiUrl?.let {
        updateGlobalContext(contextGlobal.copy(telegramApiUrl = it))
    }
    env.customReplies?.let {
        updateGlobalContext(contextGlobal.copy(customReplies = it))
    }
    updateGlobalContext(contextGlobal.copy(db = Database(env.dataDB)))
    async {
        val bots = botHashing.awaitAll().filterNotNull()
        if (bots.isEmpty()) {
            console.log("no bot found")
            null
        } else {
            contextGlobal.copy(bots=bots)
        }
    }
}