package com.example.weatherapp.model.forecast

import com.example.weatherapp.model.weather.Clouds
import com.example.weatherapp.model.weather.Main
import com.example.weatherapp.model.weather.Sys
import com.example.weatherapp.model.weather.Weather
import com.google.gson.annotations.SerializedName

data class CustomList(
    @SerializedName("dt") var dt: Int? = null,
    @SerializedName("main") var main: Main? = Main(),
    @SerializedName("weather") var weather: ArrayList<Weather>? = arrayListOf(),
    @SerializedName("clouds") var clouds: Clouds? = Clouds(),
    @SerializedName("wind") var wind: Clouds? = Clouds(),
    @SerializedName("visibility") var visibility: String? = null,
    @SerializedName("pop") var pop: Double? = null,
    @SerializedName("sys") var sys: Sys? = Sys(),
    @SerializedName("dt_txt") var dtTxt: String? = null,
)