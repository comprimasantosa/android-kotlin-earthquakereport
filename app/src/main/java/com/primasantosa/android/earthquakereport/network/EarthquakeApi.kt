package com.primasantosa.android.earthquakereport.network

import com.primasantosa.android.earthquakereport.model.EarthquakeFeatures
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthquakeApi {
    @GET("query?")
    fun getEarthquakeData(
        @Query("format") format: String,
        @Query("minmagnitude") minMagnitude: Int,
        @Query("limit") limit: Int
    ): Deferred<EarthquakeFeatures>
}