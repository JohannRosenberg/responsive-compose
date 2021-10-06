package dev.wirespec.sample

import android.app.Application
import dev.wirespec.jetmagic.composables.ScreenOrientation
import dev.wirespec.jetmagic.composables.crm
import dev.wirespec.jetmagic.initializeJetmagic
import dev.wirespec.jetmagic.models.ComposableResource
import dev.wirespec.sample.ui.countrydetails.CountryDetailsHandler
import dev.wirespec.sample.ui.countrydetails.CountryDetailsScreenHandler
import dev.wirespec.sample.ui.countrylist.CountryListHandler
import dev.wirespec.sample.ui.countrylist.CountryListScreenHandler
import dev.wirespec.sample.ui.countrylist.CountryListViewModel
import dev.wirespec.sample.ui.countrylist.land.CountryListWithDetailsScreenHandler

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeJetmagic(this)

        crm.apply {
            addComposableResources(
                mutableListOf(
                    ComposableResource(
                        resourceId = ComposableResourceIDs.CountryListScreen,
                    ) { composableInstance ->
                        CountryListScreenHandler(composableInstance)
                    },
                    ComposableResource(
                        resourceId = ComposableResourceIDs.CountryListScreen,
                        screenOrientation = ScreenOrientation.Landscape,
                    ) { composableInstance ->
                        CountryListWithDetailsScreenHandler(composableInstance)
                    },
                    ComposableResource(
                        resourceId = ComposableResourceIDs.CountryDetailsScreen,
                    ) { composableInstance ->
                        CountryDetailsScreenHandler(composableInstance)
                    },

                    // ************** List all children resources. **************

                    ComposableResource(
                        resourceId = ComposableResourceIDs.CountryList,
                        viewmodelClass = CountryListViewModel::class.java
                    ) { composableInstance ->
                        CountryListHandler(composableInstance)
                    },
                    ComposableResource(
                        resourceId = ComposableResourceIDs.CountryDetails,
                    ) { composableInstance ->
                        CountryDetailsHandler(composableInstance)
                    },
                    ComposableResource(
                        resourceId = ComposableResourceIDs.CountryDetails,
                        languageAndRegion = "de"
                    ) { composableInstance ->
                        dev.wirespec.sample.ui.countrydetails.de.CountryDetailsHandler(composableInstance)
                    },
                )
            )
        }
    }
}