package ru.mgkit.event.game.repository.web

import kotlinx.coroutines.Deferred
import org.koin.core.component.KoinComponent

interface WebRepository<K, V> : KoinComponent {

    suspend fun getAsync(key: K): Deferred<V>

    fun forEach(consumer: (K, V) -> Unit)

}