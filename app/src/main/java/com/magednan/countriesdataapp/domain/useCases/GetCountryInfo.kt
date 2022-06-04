package com.magednan.countriesdataapp.domain.useCases

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponse
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.domain.repository.CountriesRepository
import com.magednan.countriesdataapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetCountryInfo(
    val countriesRepository: CountriesRepository
){
    suspend operator fun invoke(name:String): Flow<Resource<CountryInfoResponseItem>> {
        return countriesRepository.getCountryInfo(name)
    }
}
