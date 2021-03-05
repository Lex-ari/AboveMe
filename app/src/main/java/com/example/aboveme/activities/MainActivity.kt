package com.example.aboveme.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aboveme.R
import com.example.aboveme.models.AircraftArrayList
import com.example.aboveme.services.AircraftService
import com.example.aboveme.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadAircraft()
    }


    private fun loadAircraft(){
        //initiate the service
        val destinationService = ServiceBuilder.buildService(AircraftService::class.java)
        val requestCall = destinationService.getAircraftList()

        requestCall.enqueue(object :Callback<AircraftArrayList> {
            override fun onResponse(call: Call<AircraftArrayList>, response: Response<AircraftArrayList>) {
                val aircraftList = response.body()!!
                Log.d(TAG, "onResponse: $aircraftList")
                Log.d("Response", "aircraftList size : ${aircraftList.states.size}")
            }

            override fun onFailure(call: Call<AircraftArrayList>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }

        })
    }
}