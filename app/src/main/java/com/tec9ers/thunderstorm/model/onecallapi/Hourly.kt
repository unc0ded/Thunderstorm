package com.tec9ers.thunderstorm.model.onecallapi

import com.google.gson.annotations.SerializedName
import com.tec9ers.thunderstorm.model.Weather

data class Hourly(

    @SerializedName("dt")
    val dt: Long,

    @SerializedName("temp")
    val temp: Double,

    @SerializedName("feels_like")
    val feelsLike: Double,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("dew_point")
    val dewPoint: Double,

    @SerializedName("clouds")
    val clouds: Int,

    @SerializedName("visibility")
    val visibility: Int,

    @SerializedName("wind_speed")
    val windSpeed: Double,

    @SerializedName("wind_deg")
    val windDeg: Int,

    @SerializedName("weather")
    val weather: List<Weather>,

    @SerializedName("pop")
    val pop: Double,

    @SerializedName("rain")
    val rain: Rain
)
