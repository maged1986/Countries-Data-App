package com.magednan.countriesdataapp.presention.remoteListing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.countriesdataapp.domain.useCases.AllCases
import com.magednan.countriesdataapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ApiListingViewModel @Inject constructor(
    val allCases: AllCases
): ViewModel(){
    //to hold the result of connection
    var state by mutableStateOf(ApiListingState(null,false,null))

    init {
        viewModelScope.launch {
            //check the return value
            val all= allCases.getAllRemoteCountries.countriesRepository.getAllCountries()
            all.collect{
                when(it){
                    is Resource.Success->{
                        state=state.copy(it.data)
                    }
                    is Resource.Error->{
                        state=state.copy(error = it.message.toString())
                    }
                    is Resource.Loading->{
                        state=state.copy(isLoading = true)
                    }

                }
            }
        }
    }
}