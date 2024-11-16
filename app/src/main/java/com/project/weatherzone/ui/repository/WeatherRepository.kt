package com.project.weatherzone.ui.repository

import com.project.weatherzone.data.api.ResourceState
import com.project.weatherzone.data.entity.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(apikey : String , city : String):
            Flow<ResourceState<WeatherModel>>
}