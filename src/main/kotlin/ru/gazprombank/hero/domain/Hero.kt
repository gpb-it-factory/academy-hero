package ru.gazprombank.hero.domain

import ru.gazprombank.hero.config.HeroConfig
import kotlin.random.Random

class Hero(
    private val heroConfig: HeroConfig
) {

    fun hero() = heroConfig.heroes[Random.nextInt(0, heroConfig.heroes.size)]

    companion object {

        fun emerge(heroConfig: HeroConfig) = Hero(heroConfig)

    }
}