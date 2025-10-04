package org.rzcode.rzcmp.network

import org.rzcode.rzcmp.dependencies.SampleApi
import org.rzcode.rzcmp.dependencies.SamplePost
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderService {
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): SamplePost
}

class RetrofitSampleApi(
    private val service: PlaceholderService,
) : SampleApi {
    override suspend fun getSamplePost(id: Int): SamplePost {
        return service.getPost(id)
    }
}
