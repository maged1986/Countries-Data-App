package com.magednan.countriesdataapp.data.local

import androidx.room.*
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import kotlinx.coroutines.flow.Flow


@Dao
interface CountriesDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: CountryInfoResponseItem?)

    @Query("select * from items")
    fun getAllItems(): Flow<List<CountryInfoResponseItem>>

    @Delete
    suspend fun deleteItem(item: CountryInfoResponseItem)
}