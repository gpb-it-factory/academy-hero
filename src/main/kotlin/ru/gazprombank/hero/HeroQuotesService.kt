package ru.gazprombank.hero

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HeroQuotesService

fun main(args: Array<String>) {
    runApplication<HeroQuotesService>(*args)
}