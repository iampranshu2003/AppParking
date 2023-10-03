package com.example.finalparking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParkingViewModel : ViewModel() {

    private val apiService = RetrofitInstance.apiService

    private val _parkingSpaces = MutableLiveData<List<parkingSpaces>>()
    val parkingSpaces: LiveData<List<parkingSpaces>> get() = _parkingSpaces

    init {
        // Load parking spaces when the ViewModel is created
        loadParkingSpaces()
    }

    private fun loadParkingSpaces() {
        val viewModelScope = null
        viewModelScope.launch {
            try {
                val spaces = apiService.getParkingSpaces()
                _parkingSpaces.value = spaces
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun reserveParkingSpace(spaceId: Int) {
        viewModelScope.launch {
            try {
                val reservedSpace = apiService.reserveParkingSpace(spaceId)
                // Handle reserved space, update UI, etc.
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
