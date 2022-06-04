package com.magednan.countriesdataapp.presention.localListing

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem


data class LocalDbListingState(
    val data: List<CountryInfoResponseItem>?=null,
    val isLoading:Boolean=false,
    val error:String?=null
)
