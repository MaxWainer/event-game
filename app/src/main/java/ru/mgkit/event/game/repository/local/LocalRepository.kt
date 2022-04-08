package ru.mgkit.event.game.repository.local

import org.koin.core.component.KoinComponent

interface LocalRepository<T> : KoinComponent {

    val localValue: T

}