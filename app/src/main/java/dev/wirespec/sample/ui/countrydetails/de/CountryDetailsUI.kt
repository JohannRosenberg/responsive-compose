package dev.wirespec.sample.ui.countrydetails.de

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
            .padding(20.dp)
        ) {

        Text(countryInfo.description, modifier.fillMaxWidth())
        Spacer(modifier = Modifier.requiredHeight(10.dp))
        Text("This text only shows up when the device's default language is German.", modifier.fillMaxWidth(), color = Color.Red)
    }
}