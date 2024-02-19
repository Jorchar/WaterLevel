package com.example.waterlevel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.waterlevel.data.model.Plant

@Database(entities = [Plant::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun plantDao(): PlantDao
}
