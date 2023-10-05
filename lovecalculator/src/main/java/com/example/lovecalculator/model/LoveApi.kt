package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun countCompatibility(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "afac7c454bmshfe0cda1c35962a8p1866ddjsnc3a63313a8c4",
        @Header("X-RapidAPI-Host") host : String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}