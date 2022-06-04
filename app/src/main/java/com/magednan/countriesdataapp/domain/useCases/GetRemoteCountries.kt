package com.magednan.countriesdataapp.domain.useCases

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponse
import com.magednan.countriesdataapp.domain.repository.CountriesRepository
import com.magednan.countriesdataapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetRemoteCountries (
    val countriesRepository: CountriesRepository
) {
    suspend operator fun invoke(): Flow<Resource<CountryInfoResponse>> {
        return countriesRepository.getAllCountries()
    }
}