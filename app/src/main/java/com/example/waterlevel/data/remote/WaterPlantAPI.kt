package com.example.waterlevel.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface WaterPlantAPI {
    @GET("plant")
    suspend fun getAllPlants(): Response<List<PlantDto>>
}