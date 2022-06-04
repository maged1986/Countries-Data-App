package com.magednan.countriesdataapp.presention.remoteListing

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponse


data class ApiListingState(
    val data: CountryInfoResponse?=null,
    val isLoading:Boolean=false,
    val error:String?=null
)
