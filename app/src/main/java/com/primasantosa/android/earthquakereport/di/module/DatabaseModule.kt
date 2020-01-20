package com.primasantosa.android.earthquakereport.di.module

import android.app.Application
import androidx.room.Room
import com.primasantosa.android.earthquakereport.model.EarthquakeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Volatile
    private var INSTANCE: EarthquakeDatabase? = null

    @Provides
    @Singleton
    fun providesDatabase(application: Application): EarthquakeDatabase {
        synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    application.applicationContext,
                    EarthquakeDatabase::class.java,
                    "earthquake_report_db"
                )
                    // TODO (01) Add migration scheme
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
            }
            return instance
        }
    }
}