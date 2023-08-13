@file:Suppress("OPT_IN_USAGE")

package me.heizi.workers.bot.index

import me.heizi.workers.bot.index.internal.Env
import me.heizi.workers.bot.index.internal.configs
import org.w3c.fetch.Request
import org.w3c.fetch.Response
import org.w3c.fetch.ResponseInit

@JsExport
fun fetch(request: Request,env: Env?,ctx:ExecutionContext?) : Response {
    configs(env,ctx)
    println("fetchs")
    val headers: dynamic = object {}
    headers["content-type"] = "text/plain"
    return Response(
        "Kotlin Worker hello world",
        ResponseInit(headers = headers)
    )
}

data object Config {
    var path = ""
    var owner = 0L
    var token = ""
        set(value) {
            field = value

            val hash = js("require('crypto').createHash('sha256')")
            hash.update(value)
            path = hash.digest("hex") as String
        }

}
external interface ExecutionContext