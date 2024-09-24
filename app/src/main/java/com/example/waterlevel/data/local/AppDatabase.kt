package com.example.waterlevel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.waterlevel.data.model.Converters
import com.example.waterlevel.data.model.Plant

@Database(entities = [Plant::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun plantDao(): PlantDao
}
