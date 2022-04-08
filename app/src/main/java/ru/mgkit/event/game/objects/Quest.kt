package ru.mgkit.event.game.objects

import kotlinx.serialization.Serializable

@Serializable
data class Quest(
    val number: Int,
    override val displayName: String,
    val questData: Set<QuestData>
) : Displayable
