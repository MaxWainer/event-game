package ru.mgkit.event.game.repository.web

import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.core.component.inject
import ru.mgkit.event.game.objects.Organization
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class OrganizationWebRepository : WebRepository<UUID, Organization> {

    private val httpClient: OkHttpClient by inject()
    private val json: Json by inject()
    private val coroutineScope: LifecycleCoroutineScope by inject()

    private val cache = ConcurrentHashMap<UUID, Organization>()

    override suspend fun getAsync(key: UUID): Deferred<Organization> =
        coroutineScope.async {
            if (this@OrganizationWebRepository.cache.containsKey(key)) return@async this@OrganizationWebRepository.cache[key]!!

            val request = Request.Builder()
                .url("https://api.ourdomain.ru/getOrganization/$key")
                .build()

            val response = httpClient.newCall(request).execute()

            response.use {
                val body = it.body ?: return@async run {
                    Log.e("OrganizationRepository", "An error acquired while fetching data for organization with unique id $key")

                    Organization.DUMMY
                }

                val rawResult = body.use { responseBody -> responseBody.string() }

                json.decodeFromString<Organization>(rawResult)
                    .apply { this@OrganizationWebRepository.cache[key] = this }
            }
        }

    override fun forEach(consumer: (UUID, Organization) -> Unit) {
        cache.forEach {
            consumer(it.key, it.value)
        }
    }
}