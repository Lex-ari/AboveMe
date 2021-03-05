package com.example.aboveme.services

import com.example.aboveme.models.AircraftArrayList
import retrofit2.Call
import retrofit2.http.GET

interface AircraftService {
    @GET("states/all")
    fun getAircraftList () : Call<AircraftArrayList>
}