package com.sitaram.composedesign.features.game

import com.sitaram.composedesign.features.api.ApiCallInstance
import com.sitaram.composedesign.features.api.ApiServices
import com.sitaram.composedesign.features.game.pojo.GameItems
import retrofit2.Call
import retrofit2.Retrofit

class GameModel {

    // call the api
    fun getGame(): Call<List<GameItems>> {
        val retrofit: Retrofit? = ApiCallInstance.getRetrofitInstance()
        return retrofit?.create(ApiServices::class.java)?.getGames()
            ?: throw IllegalStateException("Retrofit instance or service is null.")
    }
}