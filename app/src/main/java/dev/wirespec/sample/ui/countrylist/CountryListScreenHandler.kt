package dev.wirespec.sample.ui.countrylist

import androidx.compose.runtime.Composable
import dev.wirespec.jetmagic.composables.crm
import dev.wirespec.jetmagic.models.ComposableInstance
import dev.wirespec.sample.ComposableResourceIDs

@Composable
fun CountryListScreenHandler(composableInstance: ComposableInstance) {
    crm.RenderChildComposable(
        parentComposableId = composableInstance.id,
        composableResId = ComposableResourceIDs.CountryList,
        childComposableId = "countryList",
        p = composableInstance.parameters
    )
}