package com.magednan.countriesdataapp.domain.useCases

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.domain.repository.CountriesRepository

class InsertCountry (
    val countriesRepository: CountriesRepository
) {
    suspend operator fun invoke(item: CountryInfoResponseItem) {
        countriesRepository.insertCountry(item)
    }
}