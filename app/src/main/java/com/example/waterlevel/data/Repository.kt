package com.example.waterlevel.data

import com.example.waterlevel.data.local.AppDatabase
import com.example.waterlevel.data.model.Plant
import com.example.waterlevel.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appDatabase: AppDatabase
) {
    private val plantDao = appDatabase.plantDao()

    suspend fun getAllPlants(): Flow<List<Plant>>{
        try {
            val plants = remoteDataSource.getAllPlants()
            plantDao.insertPlant(plants)
        }catch (e: Exception){
            print(e)
        }
        return plantDao.getAllPlants()
    }
}