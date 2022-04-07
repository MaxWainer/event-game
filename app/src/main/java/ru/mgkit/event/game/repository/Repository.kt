package ru.mgkit.event.game.repository

interface Repository<K, V> {

    operator fun get(key: K): V

    val iterator: Map<K, V>

}