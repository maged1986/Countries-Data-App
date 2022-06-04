package com.magednan.countriesdataapp.presention

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.magednan.countriesdataapp.presention.countrydetails.CountryInfoScreen
import com.magednan.countriesdataapp.presention.localListing.LocalDbListingScreen
import com.magednan.countriesdataapp.presention.remoteListing.ApiListingScreen
import com.magednan.countriesdataapp.utils.Constant.COUNTRY_NAME_KEY

@Composable
fun NavGraph(navController:NavHostController){
    NavHost(
        navController,
        startDestination = NavDestination.ApiListingScreen.route
    ) {
        composable(NavDestination.ApiListingScreen.route) { ApiListingScreen(navController = navController) }
        composable(NavDestination.LocalDbListingScreen.route) { LocalDbListingScreen(navController = navController) }
        composable(NavDestination.CountryInfoScreen.route
             , arguments = listOf(
             navArgument(name = COUNTRY_NAME_KEY){
                 type= NavType.StringType
                 defaultValue=null
                 nullable=true
             }

        ) ){
            CountryInfoScreen(navController = navController) }
    }
}