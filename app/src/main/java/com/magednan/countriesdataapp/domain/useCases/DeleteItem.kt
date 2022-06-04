package com.magednan.countriesdataapp.domain.useCases

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.domain.repository.CountriesRepository

class DeleteItem (
    val countriesRepository: CountriesRepository
) {
    suspend operator fun invoke(item: CountryInfoResponseItem) {
        countriesRepository.deleteItem(item)
    }
}