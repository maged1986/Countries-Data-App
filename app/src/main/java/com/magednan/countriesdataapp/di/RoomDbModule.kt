package com.magednan.countriesdataapp.di

import android.app.Application
import androidx.room.Room
import com.magednan.countriesdataapp.data.local.CountriesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDbModule {
    @Provides
    @Singleton
    fun provideRoomDb(application: Application)=
        Room.databaseBuilder(
            application!!,
            CountriesDb::class.java,
            "roomdb"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(db: CountriesDb)=db.getDao()
}

