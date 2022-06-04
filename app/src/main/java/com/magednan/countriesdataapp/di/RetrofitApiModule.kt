package com.magednan.countriesdataapp.di

import com.magednan.countriesdataapp.data.remote.CountriesApi
import com.magednan.countriesdataapp.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        //http logging
        val loggingInterceptor= HttpLoggingInterceptor()
        loggingInterceptor.level= HttpLoggingInterceptor.Level.BODY
        //http client
        val client= OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        //retrofit instance
        val retrofit by lazy { Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build() }
        return retrofit
    }

    @Provides
    @Singleton
    fun providesApi(): CountriesApi {
        // providing api
        return provideRetrofit().create(CountriesApi::class.java)
    }
}