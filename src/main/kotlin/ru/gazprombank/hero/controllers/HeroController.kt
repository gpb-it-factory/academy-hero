package ru.gazprombank.hero.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.gazprombank.hero.service.HeroService


@RestController
@RequestMapping("/hero")
class HeroController(
    private val heroService: HeroService
) {


    @GetMapping("/said")
    fun getEmployeeById(): Mono<ResponseEntity<String>> {
        return heroService.saidQuote()
    }

}