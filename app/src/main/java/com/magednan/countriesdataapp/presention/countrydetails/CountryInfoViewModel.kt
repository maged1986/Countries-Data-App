package com.magednan.countriesdataapp.presention.countrydetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.domain.useCases.AllCases
import com.magednan.countriesdataapp.utils.Constant
import com.magednan.countriesdataapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountryInfoViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    val allCases: AllCases
) : ViewModel() {
    var state by mutableStateOf(CountryInfoState())
    lateinit var name: String

    init {
        name = savedStateHandle.get<String>(Constant.COUNTRY_NAME_KEY)!!
        setTheState()
    }

    fun saveCountry(item: CountryInfoResponseItem) {
        viewModelScope.launch {
            allCases.insertCountry.countriesRepository.insertCountry(item)
        }
    }

    fun setTheState() {
        viewModelScope.launch {
            if (name != null) {
                allCases.getCountryInfo.invoke(name).collect {
                    when (it) {
                        is Resource.Success -> {
                            state = state.copy(item = it.data)
                        }
                        is Resource.Loading -> {
                            state = state.copy(isLoading = true)
                        }
                        is Resource.Error -> {
                            state = state.copy(erorrMessage = it.message)
                        }
                    }
                }
            }
        }
    }
}