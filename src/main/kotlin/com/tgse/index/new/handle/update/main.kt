package com.tgse.index.new.handle.update

import com.tgse.index.new.UpdateHandlerScope
import com.tgse.index.new.handle.startPrivate
import com.tgse.index.new.send
import me.heizi.workers.bot.index.CustomReplies

suspend fun awaitStartChat() {
     TODO()
}
suspend fun UpdateHandlerScope.handleCommands() {
    "start" isaCommandFor { data ->
        privateChat {
            awaitStartChat()
            startPrivate(data)
        }
        disableRest(but = "private")
    }
    "help" isaCommandFor {
        privateChat {
            awaitStartChat()
            CustomReplies::helpPrivate.send()
        }
        groupChat {
            CustomReplies::helpGroup.send()
        }
    }
    "setting" isaCommandFor {
        disableRest(but = "group")
    }
    "cancel" isaCommandFor {
        privateChat {
            TODO("await-state")
        }
    }
    "update" isaCommandFor {
        privateChat {
            TODO("await-state")
        }
    }
    "mine" isaCommandFor {
       privateChat {
           TODO("await-state")
       }
    }

}