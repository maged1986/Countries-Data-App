package com.magednan.countriesdataapp.domain.useCases

data class AllCases(
    val deleteItem: DeleteItem,
    val getLocalCountries: GetLocalCountries,
    val getAllRemoteCountries: GetRemoteCountries,
    val getCountryInfo: GetCountryInfo,
    val insertCountry: InsertCountry
)
