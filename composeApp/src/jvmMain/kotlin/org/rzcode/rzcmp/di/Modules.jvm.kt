package org.rzcode.rzcmp.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rzcode.rzcmp.dependencies.MyDataBase
import org.rzcode.rzcmp.dependencies.SampleApi
import org.rzcode.rzcmp.network.PlaceholderService
import org.rzcode.rzcmp.network.RetrofitSampleApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

actual val platformModule: Module = module {
    singleOf(::MyDataBase)

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { get<Retrofit>().create(PlaceholderService::class.java) }
    singleOf(::RetrofitSampleApi).bind<SampleApi>()
}

private fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
