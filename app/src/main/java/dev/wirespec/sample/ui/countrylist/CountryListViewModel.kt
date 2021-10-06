package dev.wirespec.sample.ui.countrylist

import androidx.lifecycle.ViewModel
import dev.wirespec.sample.da.Repository

class CountryListViewModel: ViewModel() {
    val countries = Repository.countries
}