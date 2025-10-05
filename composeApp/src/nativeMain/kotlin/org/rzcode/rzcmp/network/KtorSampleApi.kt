package org.rzcode.rzcmp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.rzcode.rzcmp.dependencies.SampleApi
import org.rzcode.rzcmp.dependencies.SamplePost

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

class KtorSampleApi(
    private val httpClient: HttpClient,
) : SampleApi {
    override suspend fun getSamplePost(id: Int): SamplePost {
        return httpClient.get("$BASE_URL/posts/$id").body()
    }
}

fun provideHttpClient(): HttpClient {
    return HttpClient(Darwin) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}
