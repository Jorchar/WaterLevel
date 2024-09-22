package com.example.waterlevel.data

import com.example.waterlevel.data.local.AppDatabase
import com.example.waterlevel.data.model.Plant
import javax.inject.Inject

class Repository @Inject constructor(
    private val appDatabase: AppDatabase
) {
    private val plantDao = appDatabase.plantDao()

    fun getAllCharacters(): List<Plant> {
        return plantDao.getAllPlants()
    }
}