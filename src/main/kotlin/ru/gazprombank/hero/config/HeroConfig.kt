package ru.gazprombank.hero.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "hero")
open class HeroConfig(
    var heroes: List<String> = listOf()
)