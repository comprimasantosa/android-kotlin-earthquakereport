package com.primasantosa.android.earthquakereport.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.primasantosa.android.earthquakereport.R
import com.primasantosa.android.earthquakereport.adapter.MainAdapter
import com.primasantosa.android.earthquakereport.databinding.ActivityMainBinding
import com.primasantosa.android.earthquakereport.earthquakeReportComponent
import com.primasantosa.android.earthquakereport.network.EarthquakeApi
import com.primasantosa.android.earthquakereport.viewmodel.MainViewModel
import com.primasantosa.android.earthquakereport.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var earthquakeApi: EarthquakeApi

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        earthquakeReportComponent.inject(this)

        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        val mainAdapter = MainAdapter()

        mainViewModel.earthquakeData.observe(this, Observer {
            mainAdapter.submitList(it)

            if (it.isEmpty()) {
                binding.mainTvNoConnection.apply {
                    text = context.getString(R.string.text_no_data_available)
                    visibility = View.VISIBLE
                }
            } else {
                binding.mainTvNoConnection.apply {
                    visibility = View.GONE
                }
            }
        })
        binding.mainRvEarthquakeList.adapter = mainAdapter

        binding.mainSwipeToRefresh.setOnRefreshListener {
            mainViewModel.refreshEarthquakeData()
            binding.mainSwipeToRefresh.isRefreshing = false
        }
    }
}
