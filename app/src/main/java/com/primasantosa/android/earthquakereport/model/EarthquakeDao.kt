package com.primasantosa.android.earthquakereport.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EarthquakeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun cacheEarthquakeData(earthquake: Earthquake)

    @Query("DELETE FROM earthquake")
    suspend fun clearCacheEarthquakeData()

    @Query("SELECT * FROM earthquake ORDER BY time DESC")
    fun getEarthquakeData(): LiveData<List<Earthquake>>

}