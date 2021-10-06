package dev.wirespec.sample.ui.countrydetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.wirespec.jetmagic.models.ComposableInstance
import dev.wirespec.sample.da.CountryInfo
import dev.wirespec.sample.da.Repository

@Composable
fun CountryDetailsHandler(composableInstance: ComposableInstance) {

    // Get notified of updates.
    composableInstance.onUpdate?.observeAsState()?.value

    val countryInfo: CountryInfo

    if (composableInstance.parameters != null) {
        countryInfo = composableInstance.parameters as CountryInfo
    } else {
        countryInfo = Repository.countries[0]
    }

    CountryDetails(
        countryInfo = countryInfo
    )
}

@Composable
fun CountryDetails(
    modifier: Modifier = Modifier,
    countryInfo: CountryInfo
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,

        ) {
        Text(countryInfo.description)
    }
}