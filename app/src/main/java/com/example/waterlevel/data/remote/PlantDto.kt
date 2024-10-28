package com.example.waterlevel.data.remote

import java.util.Date

data class PlantDto(
    val id: Int?,
    val name: String?,
    val location: String?,
    val photo: String?,
    val wateredDate: Date?,
    val daysBetweenHydrate: Int?
)
