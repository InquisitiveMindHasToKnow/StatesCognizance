package org.ohmstheresistance.statescognizance.network

import org.ohmstheresistance.statescognizance.data.StateInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StateInfoService {

    @GET("{user}/ce0ca068b458801a9583a11bb335d5ca/raw/7434d33e0802276e9773e716f14522e0414d28e2/StatesInfo")
    fun retrieveStatesInformation(@Path("user") user: String): Call<List<StateInfo>>
}