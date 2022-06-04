package com.magednan.countriesdataapp.domain.useCases

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.Flow

class GetLocalCountries(
val countriesRepository: CountriesRepository
) {
    suspend operator fun invoke(): Flow<List<CountryInfoResponseItem>> {
        return  countriesRepository.getAllFavCountries()
    }
}