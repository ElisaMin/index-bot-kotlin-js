package com.tgse.index.infrastructure.repository

import com.tgse.index.domain.repository.ClassificationRepository
import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.SAXReader
import org.springframework.stereotype.Repository
import java.io.FileOutputStream
import java.nio.file.Path

@Repository
class ClassificationRepositoryImpl : ClassificationRepository {

    private val path = Path.of("lang/classification.xml")
    private lateinit var typesOnDisk: MutableList<String>

    override val classifications: Array<String>
        get() = typesOnDisk.toTypedArray()

    init {
        read()
    }

    override fun contains(classification: String): Boolean {
        return typesOnDisk.contains(classification)
    }

    override fun add(classification: String): Boolean {
        if (typesOnDisk.contains(classification)) return true
        typesOnDisk.add(classification)
        write()
        return true
    }

    override fun remove(classification: String): Boolean {
        if (!typesOnDisk.contains(classification)) return true
        typesOnDisk.remove(classification)
        write()
        return true
    }

    private fun write() {
        val outputStream = FileOutputStream(path.toFile())
        outputStream.writer(charset("UTF-8")).use {
            it.write(
                """
                <?xml version="1.0" encoding="UTF-8"?>
                <classification>
                    <content>
                        ${typesOnDisk.joinToString(",")}
                    </content>
                </classification>
                """.trimIndent()
            )
        }
    }

    private fun read() {
        val reader = SAXReader()
        val doc: Document = reader.read(path.toFile())
        val root: Element = doc.rootElement
        val it: Iterator<Element> = root.elementIterator()
        while (it.hasNext()) {
            val e: Element = it.next()
            typesOnDisk = e.textTrim.split(",").toMutableList()
        }
    }

}