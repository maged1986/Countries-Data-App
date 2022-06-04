package com.magednan.countriesdataapp.domain.repository

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponse
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Path

interface CountriesRepository {
    suspend fun getAllCountries(): Flow<Resource<CountryInfoResponse>>

    suspend fun getCountryInfo( name:String): Flow<Resource<CountryInfoResponseItem>>


    suspend fun insertCountry(item: CountryInfoResponseItem)

    suspend fun getAllFavCountries(): Flow<List<CountryInfoResponseItem>>

    suspend fun deleteItem(item: CountryInfoResponseItem)
}
