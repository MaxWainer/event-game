package ru.mgkit.event.game.objects

import kotlinx.serialization.Serializable

@Serializable
data class Level(val number: Int, val quests: Set<Quest>, override val displayName: String) :
    Displayable
