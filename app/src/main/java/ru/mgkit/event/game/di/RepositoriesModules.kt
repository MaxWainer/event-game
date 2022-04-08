package ru.mgkit.event.game.di

import org.koin.dsl.module
import ru.mgkit.event.game.repository.local.LocalUserRepository
import ru.mgkit.event.game.repository.web.OrganizationWebRepository

val REPOSITORIES_MODULES = module {
    single { LocalUserRepository() }
    single { OrganizationWebRepository() }
}