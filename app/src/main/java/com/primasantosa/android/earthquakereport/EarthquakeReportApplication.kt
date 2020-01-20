package com.primasantosa.android.earthquakereport

import android.app.Application
import com.primasantosa.android.earthquakereport.di.DaggerEarthquakeReportComponent
import com.primasantosa.android.earthquakereport.di.EarthquakeReportComponent
import timber.log.Timber

class EarthquakeReportApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        earthquakeReportComponent = DaggerEarthquakeReportComponent
            .builder()
            .application(this)
            .build()

        Timber.plant(Timber.DebugTree())
    }
}

lateinit var earthquakeReportComponent: EarthquakeReportComponent