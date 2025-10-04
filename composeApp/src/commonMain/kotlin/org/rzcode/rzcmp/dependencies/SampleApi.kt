package org.rzcode.rzcmp.dependencies

interface SampleApi {
    suspend fun getSamplePost(id: Int): SamplePost
}
