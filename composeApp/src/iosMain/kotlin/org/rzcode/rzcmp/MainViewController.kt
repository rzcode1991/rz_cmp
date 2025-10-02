package org.rzcode.rzcmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.rzcode.rzcmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(
        batteryManager = remember { BatteryManager() }
    )
}