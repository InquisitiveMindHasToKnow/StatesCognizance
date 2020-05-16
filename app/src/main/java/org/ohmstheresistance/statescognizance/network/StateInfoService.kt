package org.ohmstheresistance.statescognizance.network

import org.ohmstheresistance.statescognizance.data.StateInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StateInfoService {

    @GET("{user}/ce0ca068b458801a9583a11bb335d5ca/raw/8d46d0d807bbd0e8a6af01c76619c1c510086d9e/StatesInfo")
    fun retrieveStatesInformation(@Path("user") user: String): Call<List<StateInfo>>
}