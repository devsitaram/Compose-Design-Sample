package com.sitaram.composedesign.features.api

import com.sitaram.composedesign.features.game.pojo.GameItems
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    // local server data
    @GET("games")
    fun getGames(): Call<List<GameItems>>
}