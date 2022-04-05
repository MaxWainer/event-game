package ru.mgkit.event.game.repository

interface Repository<K, V> {

    operator fun get(k: K): V

}