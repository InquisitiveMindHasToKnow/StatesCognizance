package org.ohmstheresistance.statescognizance.network

import org.ohmstheresistance.statescognizance.data.StateInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StateInfoService {

    @GET("{user}/ce0ca068b458801a9583a11bb335d5ca/raw/e5f29aef045b21cf965c326df8b082e288364a3a/StatesInfo")
    fun retrieveStatesInformation(@Path("user") user: String): Call<List<StateInfo>>
}