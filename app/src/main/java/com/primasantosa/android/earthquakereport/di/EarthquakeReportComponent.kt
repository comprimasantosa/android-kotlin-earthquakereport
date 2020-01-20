package com.primasantosa.android.earthquakereport.di

import android.app.Application
import com.primasantosa.android.earthquakereport.di.module.*
import com.primasantosa.android.earthquakereport.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, ViewModelModule::class, RepositoryModule::class, DatabaseModule::class, DaoModule::class])
interface EarthquakeReportComponent {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): EarthquakeReportComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}