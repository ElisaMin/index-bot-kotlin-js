package com.github.kotlintelegrambot.entities

typealias ParseMode = String
const val ParseMode.MARKDOWN: ParseMode = "Markdown"
val ParseMode.HTML: ParseMode get() = "HTML"
val ParseMode.MARKDOWN_V2: ParseMode get() = "MarkdownV2"

//// TODO: Remove modeName attribute and stop using it as a serialization approach for this enum
//enum class ParseMode(val modeName: String) {
//    @JsName("Markdown")
//    MARKDOWN("Markdown"),
//
//    @JsName("HTML")
//    HTML("HTML"),
//
//    @JsName("MarkdownV2")
//    MARKDOWN_V2("MarkdownV2"),
//}
