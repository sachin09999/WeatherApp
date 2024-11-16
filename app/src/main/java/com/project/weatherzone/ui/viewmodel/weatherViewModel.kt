package com.project.weatherzone.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.weatherzone.data.Appconstants
import com.project.weatherzone.data.api.ResourceState
import com.project.weatherzone.data.entity.WeatherModel
import com.project.weatherzone.ui.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository // Inject the WeatherRepository
) : ViewModel() {

    private val _weatherResult = MutableLiveData<ResourceState<WeatherModel>>()
    val weatherResult: LiveData<ResourceState<WeatherModel>> = _weatherResult

    fun getData(city: String) {
        _weatherResult.value = ResourceState.Loading()
        viewModelScope.launch {
            try {
                weatherRepository.getWeather(Appconstants.apikey, city)
                    .collect { response ->
                        when (response) {
                            is ResourceState.Loading -> {
                                _weatherResult.value = ResourceState.Loading()
                            }
                            is ResourceState.Success -> {
                                // Check if data is not null before emitting Success
                                response.data?.let { weather ->
                                    _weatherResult.value = ResourceState.Success(weather)
                                } ?: run {
                                    _weatherResult.value = ResourceState.Error("No weather data available")
                                }
                            }
                            is ResourceState.Error -> {
                                _weatherResult.value = ResourceState.Error(response.message ?: "Failed to load data")
                            }
                        }
                    }
            } catch (e: Exception) {
                _weatherResult.value = ResourceState.Error("Failed to load data")
            }
        }
    }
}

