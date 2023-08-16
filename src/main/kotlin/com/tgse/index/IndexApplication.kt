package com.tgse.index

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class IndexApplication

fun main(args: Array<String>) {
    runApplication<IndexApplication>(*args)
}