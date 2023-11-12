package com.example.weatherapp.network

import com.example.weatherapp.constant.Const.Companion.openWeatherMapApiKey
import com.example.weatherapp.model.forecast.ForecastResult
import com.example.weatherapp.model.weather.Snow
import com.example.weatherapp.model.weather.WeatherResult
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat: Double = -21.1785719,
        @Query("lon") lng: Double = -47.829675,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = openWeatherMapApiKey
    ): WeatherResult

    @GET("forecast")
    suspend fun getForecast(
        @Query("lat") lat: Double = -21.1785719,
        @Query("lon") lng: Double = -47.829675,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = openWeatherMapApiKey
    ): ForecastResult



}