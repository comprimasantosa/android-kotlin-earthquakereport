package com.primasantosa.android.earthquakereport.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Earthquake::class], version = 1, exportSchema = false)
abstract class EarthquakeDatabase : RoomDatabase() {

    abstract fun earthquakeDao(): EarthquakeDao

}