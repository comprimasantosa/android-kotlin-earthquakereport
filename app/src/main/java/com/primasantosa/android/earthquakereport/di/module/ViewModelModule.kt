package com.primasantosa.android.earthquakereport.di.module

import com.primasantosa.android.earthquakereport.repo.EarthquakeRepository
import com.primasantosa.android.earthquakereport.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun providesMainViewModelFactory(earthquakeRepository: EarthquakeRepository): MainViewModelFactory {
        return MainViewModelFactory(earthquakeRepository)
    }
}