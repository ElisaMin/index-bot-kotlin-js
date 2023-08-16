package com.tgse.index.infrastructure.repository

import com.tgse.index.domain.repository.ReplyRepository
import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.SAXReader
import org.springframework.stereotype.Repository
import java.io.File

@Repository
class ReplyRepositoryImpl : ReplyRepository {

    private var messageOnDisk = mutableMapOf<String, String>()
    override val messages: Map<String, String>
        get() = messageOnDisk.toMap()

    init {
        // 读取xml文件内容
        val reader = SAXReader()
        val doc: Document = reader.read(File("lang/reply.xml"))
        val root: Element = doc.rootElement
        val it: Iterator<Element> = root.elementIterator()
        while (it.hasNext()) {
            val e: Element = it.next()
            val type = e.elementTextTrim("type")
            val content = e.elementText("content").replaceFirst("\n", "").replace("    ", "")
            messageOnDisk[type] = content
        }
    }

}