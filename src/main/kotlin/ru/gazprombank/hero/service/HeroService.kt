package ru.gazprombank.hero.service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import ru.gazprombank.hero.config.HeroConfig
import ru.gazprombank.hero.config.QuotesConfig
import ru.gazprombank.hero.domain.Hero


@Service
class HeroService(
    private val heroConfig: HeroConfig,
    private val quotesConfig: QuotesConfig,
    private val webClient: WebClient

) {

    fun saidQuote(): Mono<ResponseEntity<String>> {
        return webClient
            .get()
            .uri(java.lang.String.join("", quotesConfig.quotesUrl))
            .retrieve()
            .bodyToMono(String::class.java)
            .map {
                ResponseEntity.ok().body(it + BR + Hero.emerge(heroConfig).hero())
            }
    }

    companion object {
        const val BR = "<br/>"
    }

}