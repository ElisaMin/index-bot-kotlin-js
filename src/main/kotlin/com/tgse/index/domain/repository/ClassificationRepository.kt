package com.tgse.index.domain.repository

interface ClassificationRepository {

    val classifications: Array<String>

    fun contains(classification: String): Boolean

    fun add(classification: String): Boolean

    fun remove(classification: String): Boolean

}