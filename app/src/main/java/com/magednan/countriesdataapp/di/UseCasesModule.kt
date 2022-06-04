package com.magednan.countriesdataapp.di

import com.magednan.countriesdataapp.domain.repository.CountriesRepository
import com.magednan.countriesdataapp.domain.useCases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: CountriesRepository): AllCases {
        return AllCases(
            deleteItem = DeleteItem(repository),
            getAllRemoteCountries = GetRemoteCountries(repository),
            getLocalCountries = GetLocalCountries(repository),
            insertCountry = InsertCountry(repository),
            getCountryInfo = GetCountryInfo(repository)
        )
    }
}