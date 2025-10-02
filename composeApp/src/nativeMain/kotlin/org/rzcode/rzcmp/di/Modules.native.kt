package org.rzcode.rzcmp.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.rzcode.rzcmp.dependencies.MyDataBase

actual val platformModule: Module = module {
    singleOf(::MyDataBase)
}