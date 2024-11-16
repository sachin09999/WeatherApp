package com.project.weatherzone.di

import com.google.gson.GsonBuilder
import com.project.weatherzone.data.Appconstants
import com.project.weatherzone.data.api.ApiService
import com.project.weatherzone.data.datasource.weatherDatasouceImpl
import com.project.weatherzone.data.datasource.weatherDatasource
import com.project.weatherzone.ui.repository.WeatherRepository
import com.project.weatherzone.ui.repository.WeatherRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit () : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Appconstants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun proviesApiService(retrofit: Retrofit) :ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesweatherDatasource(apiService: ApiService) : weatherDatasource {
        return weatherDatasouceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesWeatherRepository(weatherdata: weatherDatasource) : WeatherRepository {
        return WeatherRepositoryImpl(weatherdata)
    }

}