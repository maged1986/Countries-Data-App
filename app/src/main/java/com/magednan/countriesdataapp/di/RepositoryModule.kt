package com.magednan.countriesdataapp.di

import com.magednan.countriesdataapp.data.repositoryImpl.CountriesRepositoryImpl
import com.magednan.countriesdataapp.domain.repository.CountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindsRepository(repositoryImpl: CountriesRepositoryImpl): CountriesRepository

}