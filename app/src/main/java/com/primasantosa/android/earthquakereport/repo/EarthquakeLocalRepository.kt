package com.primasantosa.android.earthquakereport.repo

import androidx.lifecycle.LiveData
import com.primasantosa.android.earthquakereport.model.EarthquakeDao

//class EarthquakeLocalRepository(private val earthquakeDao: EarthquakeDao) {
//
//    suspend fun cacheEarthquakeData(earthquakeLocalEntity: EarthquakeLocalEntity) {
//        return earthquakeDao.cacheEarthquakeData(earthquakeLocalEntity)
//    }
//
//    suspend fun clearCacheEarthquakeData() {
//        return earthquakeDao.clearCacheEarthquakeData()
//    }
//
//    val getEarthquakeData: LiveData<List<EarthquakeLocalEntity>> = earthquakeDao.getEarthquakeData()
//}