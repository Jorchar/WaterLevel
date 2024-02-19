package com.example.waterlevel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant (
    @PrimaryKey var id: Int = 0,
    var name: String = "",
    var location: String = "",
    var needWater: Boolean = false,
    var plantImage: String = "https://picsum.photos/200/300"
    //var waterLastDate: Date = Date(0)
)

val previewPlant = Plant(
    id = 1,
    name = "Yuka",
    location = "DinningRoom"
)
