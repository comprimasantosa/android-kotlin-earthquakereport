package com.primasantosa.android.earthquakereport.di.module

import com.primasantosa.android.earthquakereport.model.EarthquakeDao
import com.primasantosa.android.earthquakereport.model.EarthquakeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Singleton
    @Provides
    fun providesEarthquakeDao(earthquakeDatabase: EarthquakeDatabase): EarthquakeDao {
        return earthquakeDatabase.earthquakeDao()
    }
}