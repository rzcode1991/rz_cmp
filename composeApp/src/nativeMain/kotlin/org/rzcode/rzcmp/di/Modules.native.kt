package org.rzcode.rzcmp.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rzcode.rzcmp.dependencies.MyDataBase
import org.rzcode.rzcmp.dependencies.SampleApi
import org.rzcode.rzcmp.network.KtorSampleApi
import org.rzcode.rzcmp.network.provideHttpClient

actual val platformModule: Module = module {
    singleOf(::MyDataBase)
    single { provideHttpClient() }
    singleOf(::KtorSampleApi) { bind<SampleApi>() }
}
