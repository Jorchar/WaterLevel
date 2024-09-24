package com.example.waterlevel.data.remote

import com.example.waterlevel.data.model.Plant
import com.google.gson.Gson
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val gson: Gson,
    private val waterPlantAPI: WaterPlantAPI
) {
    suspend fun getAllPlants(): List<Plant> {
        val response = waterPlantAPI.getAllPlants()
        val error = gson.fromJson(response.errorBody()?.string(), Error::class.java)
        return response.body() ?: throw RuntimeException(error.message)
    }
}