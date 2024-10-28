package com.example.waterlevel.data

import com.example.waterlevel.data.local.AppDatabase
import com.example.waterlevel.data.mappers.toPlant
import com.example.waterlevel.data.model.Plant
import com.example.waterlevel.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    appDatabase: AppDatabase
) {
    private val plantDao = appDatabase.plantDao()

    fun addPlant(plant: Plant) {
        plantDao.insertPlants(listOf(plant))
    }

    private fun fetchPlantsFromRemote() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val plants = remoteDataSource.getAllPlants().map { it.toPlant() }
                plantDao.insertPlants(plants)
            } catch (e: Exception) {
                println("Could not fetch new data from server: ${e.message}")
            }
        }
    }

    fun getAllPlants(): Flow<List<Plant>> {
        fetchPlantsFromRemote()
        return plantDao.getAllPlants()
    }
}