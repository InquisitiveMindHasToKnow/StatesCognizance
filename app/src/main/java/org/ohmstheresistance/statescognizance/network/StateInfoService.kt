package org.ohmstheresistance.statescognizance.network

import org.ohmstheresistance.statescognizance.data.StateInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StateInfoService {

    @GET("{user}/ce0ca068b458801a9583a11bb335d5ca/raw/b0a3e5b52719b0c7e6a752a5db165a7ff5473fdf/StatesInfo")
    fun retrieveStatesInformation(@Path("user") user: String): Call<List<StateInfo>>
}