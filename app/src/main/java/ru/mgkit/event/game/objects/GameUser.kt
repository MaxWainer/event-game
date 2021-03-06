package ru.mgkit.event.game.objects

import kotlinx.serialization.Serializable
import ru.mgkit.event.game.serializer.UUIDSerializer
import java.util.*

@Serializable
data class GameUser(
    @Serializable(UUIDSerializer::class) val uniqueId: UUID,
    val currentLevel: Level,
    val currentQuest: Quest,
    val email: String,
    override val displayName: String
) : Displayable