package com.github.kotlintelegrambot.entities


// TODO: Remove modeName attribute and stop using it as a serialization approach for this enum
enum class ParseMode(val modeName: String) {
    @JsName("Markdown")
    MARKDOWN("Markdown"),

    @JsName("HTML")
    HTML("HTML"),

    @JsName("MarkdownV2")
    MARKDOWN_V2("MarkdownV2"),
}
