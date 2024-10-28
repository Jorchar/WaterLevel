package com.example.waterlevel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey var id: Int = 0,
    var name: String,
    var location: String,
    var photo: ByteArray,
    var wateredDate: Long,
    var daysBetweenHydrate: Int
)

val previewPlant = Plant(
    id = 1,
    name = "Yuka",
    location = "DinningRoom",
    photo = ByteArray(0),
    wateredDate = 0,
    daysBetweenHydrate = 7
)
