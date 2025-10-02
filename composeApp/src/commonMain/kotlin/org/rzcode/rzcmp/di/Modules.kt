package org.rzcode.rzcmp.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.rzcode.rzcmp.dependencies.MyRepository
import org.rzcode.rzcmp.dependencies.MyRepositoryImpl
import org.rzcode.rzcmp.dependencies.MyViewModel

expect val platformModule: Module

val sharedModule = module {

    singleOf(::MyRepositoryImpl).bind<MyRepository>()

    viewModelOf(::MyViewModel)

}