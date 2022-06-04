package com.magednan.countriesdataapp.data.remote

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponse
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    //To Get AllCountries list
    @GET("all")
    suspend fun getAllCountries(): Response<CountryInfoResponse>
    //To Get AllCountries list
    @GET("name/{name}")
    suspend fun getCountryInfo(@Path("name") name:String): Response<CountryInfoResponse>

}