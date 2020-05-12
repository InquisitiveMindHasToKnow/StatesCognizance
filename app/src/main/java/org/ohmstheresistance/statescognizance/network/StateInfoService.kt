package org.ohmstheresistance.statescognizance.network

import org.ohmstheresistance.statescognizance.data.StateInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StateInfoService {

    @GET("{user}/ce0ca068b458801a9583a11bb335d5ca/raw/fc095ec4c4cc5488f44af97b30697e5a4b8ef75a/StatesInfo")
    fun retrieveStatesInformation(@Path("user") user: String): Call<List<StateInfo>>
}