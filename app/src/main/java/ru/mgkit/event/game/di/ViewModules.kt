package ru.mgkit.event.game.di

import org.koin.dsl.module
import ru.mgkit.event.game.activity.EntryActivity
import ru.mgkit.event.game.activity.RegisterActivity

val VIEW_MODULES = module {
    single { EntryActivity() }
    single { RegisterActivity() }
}