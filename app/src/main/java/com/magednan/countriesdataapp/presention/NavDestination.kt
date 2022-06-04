package com.magednan.countriesdataapp.presention

import com.magednan.countriesdataapp.utils.Constant.COUNTRY_Info_Destination
import com.magednan.countriesdataapp.utils.Constant.COUNTRY_NAME_KEY

sealed class NavDestination( val route:String){
    object ApiListingScreen:NavDestination("ApiListingScreen")
    object CountryInfoScreen:NavDestination("CountryInfoScreen/{$COUNTRY_NAME_KEY}")
    object LocalDbListingScreen:NavDestination("LocalDbListingScreen")
}
