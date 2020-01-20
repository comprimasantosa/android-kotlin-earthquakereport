package com.primasantosa.android.earthquakereport.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EarthquakeFeatures(
    @Json(name = "features") val features: List<EarthquakeProperties>
)

@JsonClass(generateAdapter = true)
data class EarthquakeProperties(
    @Json(name = "properties") val properties: Earthquake
)

@Entity
@JsonClass(generateAdapter = true)
data class Earthquake(
    @Json(name = "time")
    @PrimaryKey
    @ColumnInfo(name = "time")
    val time: Long,

    @Json(name = "mag")
    @ColumnInfo(name = "magnitude")
    val mag: Double,

    @Json(name = "place")
    @ColumnInfo(name = "place")
    val place: String
)