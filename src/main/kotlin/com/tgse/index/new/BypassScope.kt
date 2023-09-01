package com.tgse.index.new

import me.heizi.workers.bot.index.CustomReplies

class BypassScope<C: FunctionContext>(
    val type:String
) {

    val chains = mutableListOf<BypassContextBlock<C>>()

    private var otherwise = setOf("private","group","approve")

    @Suppress("NOTHING_TO_INLINE")
    private inline fun withType(type: String, noinline block: BypassContextBlock<C>) {
        if (type==this.type) {
            otherwise-=type
            chains.add(block)
        }
    }

    fun privateChat(block: BypassContextBlock<C>) = withType("private",block)
    fun groupChat(block: BypassContextBlock<C>) = withType("group",block)
    fun approveGroup(block: BypassContextBlock<C>) = withType("approve",block)

    fun all(vararg but: String,block: BypassContextBlock<C>) {
        if (but.isEmpty()) chains.add(block)
        else but.forEach { withType(it,block) }
    }
    fun otherwise(block: BypassContextBlock<C>) {
        otherwise.forEach {
            withType(it,block)
        }
    }
    fun disableRest(but: String?=null) = otherwise {
        when (but) {
            "private" -> CustomReplies::onlyPrivate.send()
            "group"-> CustomReplies::onlyGroup.send()
            else -> CustomReplies::disable.send()
        }
        Unit
    }
}