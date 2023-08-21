@file:OptIn(ExperimentalJsExport::class)

import com.cloudflare.workers.types.ExecutionContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.promise
import me.heizi.workers.bot.index.Env
import me.heizi.workers.bot.index.main
import org.w3c.fetch.Request
import org.w3c.fetch.Response
import org.w3c.fetch.ResponseInit
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.js.Console
import kotlin.js.Promise

val globalScope = CoroutineScope(EmptyCoroutineContext)

@JsExport
@JsName("fetch")
fun entrypoint(request: Request, env: Env?, ctx: ExecutionContext?) : Promise<Response> {
    return globalScope.promise {
        debug("")
        main(request, env!!, ctx!!) ?: Response(null, ResponseInit(status = 404))
    }
}
@Suppress("NOTHING_TO_INLINE")
inline fun debug(vararg o:dynamic) = console.asDynamic().unsafeCast<com.cloudflare.workers.types.Console>().debug(*o)