package com.magednan.countriesdataapp.presention.countrydetails

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem


data class CountryInfoState(val item: CountryInfoResponseItem?=null,
                            val erorrMessage:String?=null,
                            val isLoading:Boolean=false)
