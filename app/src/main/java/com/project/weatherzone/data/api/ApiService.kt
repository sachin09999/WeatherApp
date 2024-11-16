package com.project.weatherzone.data.api

import com.project.weatherzone.data.entity.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apikey : String ,
        @Query("q") city : String
    ): Response<WeatherModel>
}
