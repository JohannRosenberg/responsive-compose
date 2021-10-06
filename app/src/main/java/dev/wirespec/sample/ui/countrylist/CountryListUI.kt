package dev.wirespec.sample.ui.countrylist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.wirespec.jetmagic.composables.crm
import dev.wirespec.jetmagic.models.ComposableInstance
import dev.wirespec.sample.ComposableResourceIDs
import dev.wirespec.sample.da.CountryInfo

@Composable
fun CountryListHandler(composableInstance: ComposableInstance) {
    val vm = composableInstance.viewmodel as CountryListViewModel

    CountryList(
        countries = vm.countries,
        onItemClick = { countryInfo ->
            crm.updateOrGoto(
                parentComposableInstance = composableInstance,
                childComposableResourceId = ComposableResourceIDs.CountryDetails,
                fullscreenComposableResourceId = ComposableResourceIDs.CountryDetailsScreen,
                p = countryInfo
            )
        })
}

@Composable
fun CountryList(
    modifier: Modifier = Modifier,
    countries: List<CountryInfo>,
    onItemClick: (countryInfo: CountryInfo) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Top

    ) {
        countries.forEach { countryInfo ->
            Text(countryInfo.name, fontSize = 20.sp,
                modifier = Modifier
                    .clickable {
                        onItemClick(countryInfo)
                    }
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 5.dp, bottom = 5.dp)
            )
        }
    }
}

