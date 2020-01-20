package com.primasantosa.android.earthquakereport.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.primasantosa.android.earthquakereport.model.Earthquake
import com.primasantosa.android.earthquakereport.repo.EarthquakeRepository
import kotlinx.coroutines.*

class MainViewModel(private val earthquakeRepository: EarthquakeRepository) : ViewModel() {

    val earthquakeData: LiveData<List<Earthquake>>

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        refreshEarthquakeData()
        earthquakeData = earthquakeRepository.getEarthquakeData
    }

    fun refreshEarthquakeData() {
        coroutineScope.launch {
            withContext(Dispatchers.IO) {
                earthquakeRepository.getEarthquakeData()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}