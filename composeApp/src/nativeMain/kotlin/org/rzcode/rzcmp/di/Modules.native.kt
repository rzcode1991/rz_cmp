package org.rzcode.rzcmp.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rzcode.rzcmp.dependencies.MyDataBase
import org.rzcode.rzcmp.dependencies.SampleApi
import org.rzcode.rzcmp.dependencies.SamplePost

actual val platformModule: Module = module {
    singleOf(::MyDataBase)
    singleOf(::StubSampleApi).bind<SampleApi>()
}

private class StubSampleApi : SampleApi {
    override suspend fun getSamplePost(id: Int): SamplePost {
        return SamplePost(
            userId = 0,
            id = id,
            title = "Sample post unavailable on this platform",
            body = "Retrofit is only configured for Android and desktop targets in this sample.",
        )
    }
}
