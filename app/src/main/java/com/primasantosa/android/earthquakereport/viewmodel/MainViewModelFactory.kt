package com.primasantosa.android.earthquakereport.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.primasantosa.android.earthquakereport.repo.EarthquakeRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val earthquakeRepository: EarthquakeRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(earthquakeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}