package com.magednan.countriesdataapp.presention

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.data.repositoryImpl.CountriesRepositoryImpl
import com.magednan.countriesdataapp.presention.countrydetails.CountryInfoScreen
import com.magednan.countriesdataapp.presention.localListing.LocalDbListingScreen
import com.magednan.countriesdataapp.presention.remoteListing.ApiListingScreen
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import javax.inject.Singleton
import kotlin.time.measureTime

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainNav(){
    val navController = rememberNavController()
   Scaffold(
        bottomBar = { BottomNav(navController = navController) }
   ) {
       NavGraph(navController = navController)
   }
}