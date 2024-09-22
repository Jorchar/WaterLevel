package com.example.waterlevel.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.waterlevel.data.model.Plant

@Dao
interface PlantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlant(plants: List<Plant>)

    @Query("SELECT * FROM plants")
    fun getAllPlants(): List<Plant>

    @Query("SELECT * FROM plants WHERE id LIKE :plantId")
    fun getPlantById(plantId: Int): Plant

    @Query("DELETE FROM plants")
    fun deleteAllPlants()
}
