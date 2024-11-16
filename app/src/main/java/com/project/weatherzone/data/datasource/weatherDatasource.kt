package com.project.weatherzone.data.datasource

import com.project.weatherzone.data.entity.WeatherModel
import retrofit2.Response

interface weatherDatasource {
    suspend fun getWeather(
        apikey : String,
        city : String
    ) : Response<WeatherModel>

}