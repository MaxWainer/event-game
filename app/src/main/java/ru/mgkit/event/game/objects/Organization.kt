package ru.mgkit.event.game.objects

import kotlinx.serialization.Serializable
import ru.mgkit.event.game.serializer.UUIDSerializer
import java.util.*

@Serializable
data class Organization(
    @Serializable(UUIDSerializer::class) val uniqueId: UUID,
    override val displayName: String
) : Displayable {

    companion object {
        val DUMMY = Organization(UUID(0, 0), "DUMMY")
    }

    val dummy: Boolean = uniqueId == DUMMY.uniqueId && displayName == DUMMY.displayName

}