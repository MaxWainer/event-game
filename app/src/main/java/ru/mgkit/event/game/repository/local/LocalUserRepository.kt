package ru.mgkit.event.game.repository.local

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.core.component.inject
import ru.mgkit.event.game.EventGameActivity
import ru.mgkit.event.game.objects.GameUser

class LocalUserRepository : LocalRepository<GameUser> {

    private val activity: EventGameActivity by inject()
    private val json: Json by inject()

    override val localValue: GameUser by lazy {
        val preference = activity.getSharedPreferences("user_data", Context.MODE_PRIVATE)

        json.decodeFromString(preference.getString("data", "{}") ?: "{}")
    }

}