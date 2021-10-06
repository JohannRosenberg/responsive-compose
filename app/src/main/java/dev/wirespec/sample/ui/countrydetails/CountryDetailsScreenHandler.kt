package dev.wirespec.sample.ui.countrydetails

import androidx.compose.runtime.Composable
import dev.wirespec.jetmagic.composables.crm
import dev.wirespec.jetmagic.models.ComposableInstance
import dev.wirespec.sample.ComposableResourceIDs

@Composable
fun CountryDetailsScreenHandler(composableInstance: ComposableInstance) {
    crm.RenderChildComposable(
        parentComposableId = composableInstance.id,
        composableResId = ComposableResourceIDs.CountryDetails,
        childComposableId = "countryDetails",
        p = composableInstance.parameters
    )
}