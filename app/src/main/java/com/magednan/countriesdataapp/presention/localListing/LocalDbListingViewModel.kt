package com.magednan.countriesdataapp.presention.localListing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.domain.useCases.AllCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LocalDbListingViewModel @Inject constructor(
    val allCases: AllCases
) : ViewModel() {
    //to hold the result of connection
    var state by mutableStateOf(LocalDbListingState(null, false, null))


    lateinit var list: List<CountryInfoResponseItem>

    init {
        viewModelScope.launch {
            //check the return value
            allCases.getAllRemoteCountries.countriesRepository.getAllFavCountries()
                .collect { list1 ->
                    state = state.copy(data = list1)
                }
        }
    }

    fun deleteItem(item: CountryInfoResponseItem) {
        viewModelScope.launch {
            allCases.deleteItem(item)
        }
    }
}