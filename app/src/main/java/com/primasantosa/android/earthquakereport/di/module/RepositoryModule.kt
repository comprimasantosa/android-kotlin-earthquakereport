package com.primasantosa.android.earthquakereport.di.module

import com.primasantosa.android.earthquakereport.model.EarthquakeDao
import com.primasantosa.android.earthquakereport.network.EarthquakeApi
import com.primasantosa.android.earthquakereport.repo.EarthquakeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesEarthquakeRepository(
        earthquakeApi: EarthquakeApi,
        earthquakeDao: EarthquakeDao
    ): EarthquakeRepository {
        return EarthquakeRepository(earthquakeApi, earthquakeDao)
    }
}