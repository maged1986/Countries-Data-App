package com.magednan.countriesdataapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import com.magednan.countriesdataapp.presention.MainNav
import com.magednan.countriesdataapp.presention.NavDestination
import com.magednan.countriesdataapp.presention.localListing.LocalDbListingScreen
import com.magednan.countriesdataapp.presention.remoteListing.ApiListingScreen
import com.magednan.countriesdataapp.ui.theme.CountriesDataAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.DestinationsNavController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController as rememberNavController1

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesDataAppTheme {
                Column(Modifier.fillMaxSize()) {
                    MainNav()
                }

            }
        }
    }
}
