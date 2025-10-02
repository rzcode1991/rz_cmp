package org.rzcode.rzcmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.rzcode.rzcmp.di.initKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }

}