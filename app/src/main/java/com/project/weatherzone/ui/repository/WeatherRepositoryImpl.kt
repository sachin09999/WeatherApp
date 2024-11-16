package com.project.weatherzone.ui.repository
import com.project.weatherzone.data.api.ResourceState
import com.project.weatherzone.data.datasource.weatherDatasource
import com.project.weatherzone.data.entity.WeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherdata: weatherDatasource
) : WeatherRepository {

    override fun getWeather(apikey: String, city: String): Flow<ResourceState<WeatherModel>> {
        return flow {
            emit(ResourceState.Loading())

            val response = weatherdata.getWeather(apikey, city)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching weather data: ${response.message()}"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}
