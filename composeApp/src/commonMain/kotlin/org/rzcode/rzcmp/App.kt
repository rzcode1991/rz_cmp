package org.rzcode.rzcmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.rzcode.rzcmp.dependencies.MyViewModel

@Composable
@Preview
fun App(
    batteryManager: BatteryManager
) {
    MaterialTheme {

        NavHost(
            navController = rememberNavController(),
            startDestination = "Home"
        ){

            composable(
                route = "Home"
            ) {

                val viewModel = koinViewModel<MyViewModel>()
                val batteryLevel = remember { batteryManager.getBatteryLevel() }

                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .safeContentPadding()
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "battery level is: $batteryLevel %"
                    )

                    Text(
                        text = viewModel.getHelloWorld()
                    )

                }

            }

        }
    }
}