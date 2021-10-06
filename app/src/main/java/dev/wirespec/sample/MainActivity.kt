package dev.wirespec.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.wirespec.jetmagic.composables.ScreenFactoryHandler
import dev.wirespec.jetmagic.composables.crm
import dev.wirespec.jetmagic.navigation.navman
import dev.wirespec.sample.ui.theme.ResponsivecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navman.activity = this

        if (navman.totalScreensDisplayed == 0) {
            navman.goto(composableResId = ComposableResourceIDs.CountryListScreen)
        }

        setContent {
            ResponsivecomposeTheme {
                ScreenFactoryHandler()
            }
        }
    }

    override fun onBackPressed() {
        if (!navman.goBack())
            super.onBackPressed()
    }

    override fun onDestroy() {
        crm.onConfigurationChanged()
        super.onDestroy()
    }
}
