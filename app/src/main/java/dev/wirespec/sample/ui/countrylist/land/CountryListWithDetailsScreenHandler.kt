package dev.wirespec.sample.ui.countrylist.land

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.wirespec.jetmagic.composables.crm
import dev.wirespec.jetmagic.models.ComposableInstance
import dev.wirespec.sample.ComposableResourceIDs

@Composable
fun CountryListWithDetailsScreenHandler(composableInstance: ComposableInstance) {

    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            crm.RenderChildComposable(
                parentComposableId = composableInstance.id,
                composableResId = ComposableResourceIDs.CountryList,
                childComposableId = "countryList",
                p = composableInstance.parameters
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            crm.RenderChildComposable(
                parentComposableId = composableInstance.id,
                composableResId = ComposableResourceIDs.CountryDetails,
                childComposableId = "countryDetails",
                p = composableInstance.parameters
            )
        }
    }
}