package com.magednan.countriesdataapp.data.repositoryImpl

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponse
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.data.local.CountriesDao
import com.magednan.countriesdataapp.data.remote.CountriesApi
import com.magednan.countriesdataapp.domain.repository.CountriesRepository
import com.magednan.countriesdataapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
   private val dao: CountriesDao,
   private val api: CountriesApi
): CountriesRepository {

    override suspend fun getAllCountries(): Flow<Resource<CountryInfoResponse>> {
        return flow{
            try{
                emit(Resource.Loading(isLoading = true))
                val response=api.getAllCountries()
                if(response.isSuccessful && !response.body().isNullOrEmpty()){
                    emit(Resource.Success(data = response.body()))
                }
            }
            catch (e: IOException){
                emit(Resource.Error(message = e.message.toString()))
            }
            catch (e: HttpException){
                emit(Resource.Error(message = e.message.toString()))
            }
        }

    }

    override suspend fun getCountryInfo(name: String): Flow<Resource<CountryInfoResponseItem>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            try {
                val response=api.getCountryInfo(name)
                if (response.isSuccessful){
                    emit(Resource.Success(data = response.body()?.get(0)))
                }
            }catch (e :IOException){
                emit(Resource.Error(message = e.message.toString()))
            }catch (e:HttpException){
                emit(Resource.Error(message = e.message.toString()))
            }
        }
    }

    override suspend fun insertCountry(item: CountryInfoResponseItem) {
        dao.insertItem(item)
    }

    override suspend fun getAllFavCountries(): Flow<List<CountryInfoResponseItem>> {
        return  dao.getAllItems()
    }

    override suspend fun deleteItem(item: CountryInfoResponseItem) {
        dao.deleteItem(item)
    }
}