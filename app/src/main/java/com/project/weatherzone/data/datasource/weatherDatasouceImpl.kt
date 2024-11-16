package com.project.weatherzone.data.datasource

import com.project.weatherzone.data.api.ApiService
import com.project.weatherzone.data.entity.WeatherModel
import retrofit2.Response
import javax.inject.Inject

class weatherDatasouceImpl @Inject
constructor(private val apiService: ApiService) : weatherDatasource {
    override suspend fun getWeather(apikey : String ,city: String): Response<WeatherModel> {
        return apiService.getWeather(apikey,city)
    }
}