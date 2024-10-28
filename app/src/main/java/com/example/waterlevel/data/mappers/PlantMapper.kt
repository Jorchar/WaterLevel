package com.example.waterlevel.data.mappers

import android.util.Base64
import com.example.waterlevel.data.model.Plant
import com.example.waterlevel.data.remote.PlantDto
import java.util.Date


fun timestampToDate(value: Long): Date {
    return Date(value)
}

fun dateToTimestamp(date: Date?): Long? {
    return date?.time
}

fun byteArrayToString(byteArray: ByteArray): String {
    return byteArray.let { Base64.encodeToString(it, Base64.DEFAULT) }
}

fun stringToByteArray(value: String?): ByteArray? {
    return value?.let { Base64.decode(it, Base64.DEFAULT) }
}

fun PlantDto.toPlant(): Plant {
    return Plant(
        id = id ?: 0,
        name = name ?: "",
        location = location ?: "",
        photo = stringToByteArray(photo) ?: ByteArray(0),
        wateredDate = dateToTimestamp(wateredDate) ?: 0,
        daysBetweenHydrate = daysBetweenHydrate ?: 0
    )
}

fun Plant.toPlantDto(): PlantDto {
    return PlantDto(
        id = id,
        name = name,
        location = location,
        photo = byteArrayToString(photo),
        wateredDate = timestampToDate(wateredDate),
        daysBetweenHydrate = daysBetweenHydrate
    )

}