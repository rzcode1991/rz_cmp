package org.rzcode.rzcmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.rzcode.rzcmp.di.initKoin

fun main(){

    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "rzcmp",
        ) {
            App(
                batteryManager = remember { BatteryManager() }
            )
        }
    }

}