package com.primasantosa.android.earthquakereport.repo

import androidx.lifecycle.LiveData
import com.primasantosa.android.earthquakereport.model.Earthquake
import com.primasantosa.android.earthquakereport.model.EarthquakeDao
import com.primasantosa.android.earthquakereport.model.EarthquakeProperties
import com.primasantosa.android.earthquakereport.network.EarthquakeApi
import com.primasantosa.android.earthquakereport.util.FORMAT
import com.primasantosa.android.earthquakereport.util.LIMIT
import com.primasantosa.android.earthquakereport.util.MINMAGNITUDE
import timber.log.Timber
import javax.inject.Singleton

@Singleton
class EarthquakeRepository(
    private val earthquakeApi: EarthquakeApi,
    private val earthquakeDao: EarthquakeDao
) {

    suspend fun getEarthquakeData() {
        var list = listOf<EarthquakeProperties>()
        val earthquakeDataDeferred = earthquakeApi.getEarthquakeData(FORMAT, MINMAGNITUDE, LIMIT)
        try {
            val result = earthquakeDataDeferred.await()
            list = result.features
            list.map {
                earthquakeDao.cacheEarthquakeData(
                    Earthquake(
                        time = it.properties.time,
                        mag = it.properties.mag,
                        place = it.properties.place
                    )
                )
            }
        } catch (e: Exception) {
            Timber.i("$e")
        }
    }
    val getEarthquakeData: LiveData<List<Earthquake>> = earthquakeDao.getEarthquakeData()

}