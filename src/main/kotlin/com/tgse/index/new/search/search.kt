package com.tgse.index.new.search

import com.tgse.index.new.db.DatabaseAlisObject
import com.tgse.index.new.handle.Enrol
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

typealias Enrols = List<Enrol>

suspend fun String.searchForm(db:DatabaseAlisObject):Enrols {
    var keyword = this.trim()
    if (keyword.isEmpty()) return emptyList()
    if (keyword.length in 3..5) {
        db.searchEnrolsByCategory(keyword)?.let {
            return it
        }
    }
    while (keyword.contains("  ")) keyword = keyword.replace("  "," ")
    val results = hashMapOf<String,Enrol>()
    val scores = hashMapOf<String,Deferred<Float>>()
    val keywords = keyword.split(" ")
    coroutineScope {
        keywords.filter {
            it.length in 2..6
        }.let {
            db.searchEnrolsByTag(it)?.forEach {enrol ->
                results[enrol.uuid] = enrol
                scores[enrol.uuid] = async {
                    with(db) {enrol.score()}
                }
            }
        }
        db.searchEnrolsByKeyword(keyword)?.forEach {enrol ->
            results[enrol.uuid] = enrol
            scores[enrol.uuid] = async {
                with(db) {enrol.score()}
            }
        }
    }
    scores.map {
        results[it.key]!! to it.value.await()
    }.sortedByDescending { it.second }.map {
        it.first
    }.let {
        return it
    }
}