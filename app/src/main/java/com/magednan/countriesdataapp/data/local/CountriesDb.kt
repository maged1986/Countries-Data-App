package com.magednan.countriesdataapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem


@Database(entities = [CountryInfoResponseItem::class], version = 1)
@TypeConverters(CountriesTypeConverts::class)
abstract class CountriesDb : RoomDatabase(){

    abstract fun getDao():CountriesDao

}