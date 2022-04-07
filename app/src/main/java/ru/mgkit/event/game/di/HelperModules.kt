package ru.mgkit.event.game.di

import kotlinx.serialization.json.Json
import org.koin.dsl.module

val HELPERS_MODULES = module {
    single { Json {
        allowSpecialFloatingPointValues = true
    } }
}